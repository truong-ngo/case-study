import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product";
import {Category} from "../model/category";
import {Subject} from "rxjs";

const apiUrl = environment.apiUrl

@Injectable()
export class CategoryService {
  categories: Category[] = []
  categoriesChange = new Subject<Category[]>()

  constructor(private http: HttpClient) {

  }

  getCategories() {
    return this.http.get<Category[]>(`${apiUrl}/categories`)
  }

  getCategory(id?: number) {
    return this.http.get<Category>(`${apiUrl}/categories/${id}`)
  }

  addCategory(category: Category) {
    return this.http.post<Category>(`${apiUrl}/categories`, category)
  }

  editCategory(category: Category) {
    return this.http.put<Category>(`${apiUrl}/categories`, category)
  }

  deleteCategory(id?: number) {
    return this.http.delete<Product>(`${apiUrl}/categories/${id}`)
  }
}
