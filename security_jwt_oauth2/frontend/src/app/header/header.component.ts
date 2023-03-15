import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  isLogin?: boolean
  loginSub = new Subscription()

  constructor(private authService: AuthService,
              private router: Router) {

  }

  ngOnInit() {
    let user = sessionStorage.getItem('userData')
    this.isLogin = !!user;
    this.loginSub = this.authService.userChange.subscribe(
      data => {
        this.isLogin = !!data;
      }
    )
  }

  ngOnDestroy() {
    this.loginSub.unsubscribe();
  }

  logout() {
    this.authService.userChange.next(null);
    sessionStorage.removeItem('userData')
    localStorage.removeItem('userData')
    this.router.navigate(['/home'])
  }
}
