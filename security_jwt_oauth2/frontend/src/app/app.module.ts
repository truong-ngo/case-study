import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {HomeComponent} from './home/home.component';
import {ProductsComponent} from './products/products.component';
import {CategoriesComponent} from './categories/categories.component';
import {ProductService} from "./service/product.service";
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {CategoryService} from "./service/category.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProductFormComponent} from './products/product-form/product-form.component';
import {ProductResolver} from "./service/product-resolver";
import {SweetAlert2Module} from '@sweetalert2/ngx-sweetalert2';
import {ProductDetailsComponent} from './products/product-details/product-details.component';
import {CategoryFormComponent} from './categories/category-form/category-form.component';
import {CategoryResolver} from "./service/category-resolver";
import {CategoryDetailsComponent} from './categories/category-details/category-details.component';
import {AuthComponent} from './auth/auth.component';
import {AuthService} from "./auth/auth.service";
import {AuthInterceptor} from "./auth/auth.interceptor";
import {AuthGuard} from "./auth/auth.guard";
import {SortPipe} from "./service/sort.pipe";
import {FilterPipe} from "./service/filter.pipe";
import {AngularFireStorageModule} from "@angular/fire/compat/storage";
import {AngularFireDatabaseModule} from "@angular/fire/compat/database";
import {AngularFireModule} from "@angular/fire/compat";
import {environment} from "../environments/environment";
import {ScreenTrackingService,UserTrackingService} from '@angular/fire/analytics';
import {FileUploadService} from "./service/file-upload.service";
import {
    GoogleLoginProvider,
    GoogleSigninButtonModule,
    SocialAuthServiceConfig,
    SocialLoginModule
} from "@abacritt/angularx-social-login";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ProductsComponent,
    CategoriesComponent,
    ProductFormComponent,
    ProductDetailsComponent,
    CategoryFormComponent,
    CategoryDetailsComponent,
    AuthComponent,
    SortPipe,
    FilterPipe,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FontAwesomeModule,
        HttpClientModule,
        ReactiveFormsModule,
        [SweetAlert2Module.forRoot()],
        FormsModule,
        AngularFireModule.initializeApp(environment.firebase),
        AngularFireStorageModule,
        AngularFireDatabaseModule,
        SocialLoginModule,
        GoogleSigninButtonModule
    ],
  providers: [ProductService, CategoryService, ProductResolver, CategoryResolver, AuthService, AuthGuard,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
    ScreenTrackingService,UserTrackingService, FileUploadService,
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '620692137780-v6p6mghd2ea2t5hh8i5sqr1roe226361.apps.googleusercontent.com'
            )
          },
        ],
        onError: (err) => {
          console.error(err);
        }
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
