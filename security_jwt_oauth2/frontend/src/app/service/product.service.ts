import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product";
import {Subject} from "rxjs";
import {environment} from "../../environments/environment";

const apiUrl = environment.apiUrl

@Injectable()
export class ProductService {
  productsChange = new Subject<Product[]>()
  products: Product[]

  constructor(private http: HttpClient) {
    this.products = []
  }

  getProducts() {
    return this.http.get<Product[]>(`${apiUrl}/products`)
  }

  getProduct(id?: number) {
    return this.http.get<Product>(`${apiUrl}/products/${id}`)
  }

  addProduct(product: Product) {
    return this.http.post<Product>(`${apiUrl}/products`, product)
  }

  editProduct(product: Product) {
    return this.http.put<Product>(`${apiUrl}/products`, product)
  }

  deleteProduct(id?: number) {
    return this.http.delete<Product>(`${apiUrl}/products/${id}`)
  }
}
