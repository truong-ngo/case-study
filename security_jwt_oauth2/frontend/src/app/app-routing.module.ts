import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ProductsComponent} from "./products/products.component";
import {CategoriesComponent} from "./categories/categories.component";
import {ProductFormComponent} from "./products/product-form/product-form.component";
import {ProductResolver} from "./service/product-resolver";
import {ProductDetailsComponent} from "./products/product-details/product-details.component";
import {CategoryFormComponent} from "./categories/category-form/category-form.component";
import {CategoryResolver} from "./service/category-resolver";
import {CategoryDetailsComponent} from "./categories/category-details/category-details.component";
import {AuthComponent} from "./auth/auth.component";
import {AuthGuard} from "./auth/auth.guard";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: "full"},
  {path: 'products', component: ProductsComponent, canActivate: [AuthGuard], resolve: [ProductResolver, CategoryResolver], children: [
      {path: 'new', component: ProductFormComponent},
      {path: ':id/edit', component: ProductFormComponent},
    ]},
  {path: 'products/:id', component: ProductDetailsComponent, canActivate: [AuthGuard]},
  {path: 'home', component: HomeComponent},
  {path: 'categories', component: CategoriesComponent, canActivate: [AuthGuard], resolve: [CategoryResolver], children: [
      {path: 'new', component: CategoryFormComponent},
      {path: ':id/edit', component: CategoryFormComponent},
      {path: ':id', component: CategoryDetailsComponent},
    ]},
  {path: 'auth', component: AuthComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
