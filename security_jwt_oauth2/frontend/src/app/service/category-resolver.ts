import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable, tap} from "rxjs";
import {Injectable} from "@angular/core";
import {Category} from "../model/category";
import {CategoryService} from "./category.service";

@Injectable()
export class CategoryResolver implements Resolve<Category[]> {
  constructor(private categoryService: CategoryService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Category[]> | Promise<Category[]> | Category[] {
    return this.categoryService.getCategories().pipe(tap(
      data => {
        this.categoryService.categories = data;
      }
    ));
  }
}
