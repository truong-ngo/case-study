import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {ProductService} from "../service/product.service";
import {faPenToSquare, faTrash} from "@fortawesome/free-solid-svg-icons";
import SAlert from "sweetalert2";
import {CategoryService} from "../service/category.service";
import {Category} from "../model/category";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[] = []
  categories: Category[] = []
  editIcon = faPenToSquare
  deleteIcon = faTrash
  prop: string = '';
  order: string = '';
  categoryName: string = '';

  constructor(private productService: ProductService,
              private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.products = this.productService.products;
    this.categories = this.categoryService.categories;
    this.productService.productsChange.subscribe(
      data => {
        this.products = data
      }
    )
    this.categoryService.categoriesChange.subscribe(
      data => {
        this.categories = data
      }
    )
  }

  deleteProduct(product: Product){
    SAlert.fire({
      title: 'Are you sure want to remove?',
      text: 'You will not be able to recover this product!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes',
      cancelButtonText: 'No'
    }).then((result) => {
      if (result.value) {
        this.productService.deleteProduct(product.id).subscribe(
          () => {
            SAlert.fire(
              'Deleted!',
              'Product has been deleted',
              'success'
            ).then()
            this.handleDelete()
          }
        )
      } else if (result.dismiss === SAlert.DismissReason.cancel) {
        SAlert.fire(
          'Cancelled',
          '',
          'error'
        ).then()
      }
    })
  }

  handleDelete() {
    this.productService.getProducts().subscribe(
      data => {
        this.productService.productsChange.next(data);
      }
    )
  }
}
