import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, Params} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product?: Product

  constructor(private productService: ProductService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    // let id = +this.route.snapshot.params['id']
    // this.handleProductGet(id)
    this.route.params.subscribe(
      (params: Params) => {
        this.handleProductGet(+params['id'])
      }
    )
  }

  handleProductGet(id: number) {
    this.productService.getProduct(id).subscribe(
      data => {
        this.product = data
      }
    )
  }
}
