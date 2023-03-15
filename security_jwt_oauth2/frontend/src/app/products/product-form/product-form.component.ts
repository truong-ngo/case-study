import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {Product} from "../../model/product";
import {faCameraAlt} from "@fortawesome/free-solid-svg-icons";

import * as $ from 'jquery'
import {FileUploadService} from "../../service/file-upload.service";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  categories?: Category[]
  product: Product = new Product()
  editMode = false;
  isModalOpen = false;
  editId?: number;
  faCamera = faCameraAlt
  productForm = new FormGroup({
    name: new FormControl(null),
    price: new FormControl(null),
    description: new FormControl(null),
    image: new FormControl(null),
    category: new FormGroup({
      id: new FormControl(1)
    }),
  })

  defaultImage: any = '/assets/white.png';

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private route: ActivatedRoute,
              private router: Router,
              private uploadService: FileUploadService) {
  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params) => {
        this.editMode = !!params['id']
        if (this.editMode) {
          this.editId = +params['id']
        }
        this.categoryService.getCategories().subscribe(
          data => {
            this.categories = data
            this.initForm();
          }
        )
      }
    )
  }

  initForm() {
    if (this.editMode) {
      this.productService.getProduct(this.editId).subscribe(
        data => {
          // @ts-ignore
          this.productForm.patchValue(data);
        }
      )
    }
  }

  onSubmit() {
    this.product = this.productForm.value as Product
    const files = $('.input-product-img').prop('files')
    if (this.productForm.invalid) {
      return
    }
    if (this.editMode) {
      this.product.id = this.editId
      this.handleEdit(files);
    } else {
      this.handleAdd(files);
    }
  }

  private handleAdd(files: File[]) {
    if (files && files[0]) {
      this.uploadService.pushFileToStorage('image/products', files[0]).subscribe(
        url => {
          this.product.image = url;
          this.productService.addProduct(this.product).subscribe(
            () => {
              this.productService.getProducts().subscribe(
                (data) => {
                  this.productService.productsChange.next(data)
                  this.router.navigate(['/products']).finally()
                }
              )
            }
          )
        }
      )
    } else {
      this.productService.addProduct(this.product).subscribe(
        () => {
          this.productService.getProducts().subscribe(
            (data) => {
              this.productService.productsChange.next(data)
              this.router.navigate(['/products']).finally()
            }
          )
        }
      )
    }
  }

  private handleEdit(files: File[]) {
    if (files && files[0]) {
      this.uploadService.pushFileToStorage('image/products', files[0]).subscribe(
        url => {
          this.product.image = url;
          this.productService.editProduct(this.product).subscribe(
            () => {
              this.productService.getProducts().subscribe(
                (data) => {
                  this.productService.productsChange.next(data)
                  this.router.navigate(['/products']).finally()
                }
              )
            }
          )
        }
      )
    } else {
      this.productService.editProduct(this.product).subscribe(
        () => {
          this.productService.getProducts().subscribe(
            (data) => {
              this.productService.productsChange.next(data)
              this.router.navigate(['/products']).finally()
            }
          )
        }
      )
    }
  }

  openUpload(s: string) {
    $(s).trigger('click')
  }

  renderImagePath(event: any) {
    const files = event.target.files;
    const reader = new FileReader()
    if (files && files[0]) {
      reader.onload = () => {
        this.defaultImage = reader.result
      }
      reader.readAsDataURL(files[0])
    }
  }
}
