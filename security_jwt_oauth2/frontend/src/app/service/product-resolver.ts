import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Product} from "../model/product";
import {Observable, tap} from "rxjs";
import {Injectable} from "@angular/core";
import {ProductService} from "./product.service";

@Injectable()
export class ProductResolver implements Resolve<Product[]> {
  constructor(private productService: ProductService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Product[]> | Promise<Product[]> | Product[] {
    return this.productService.getProducts().pipe(tap(
      data => {
        this.productService.products = data;
      }
    ));
  }
}
