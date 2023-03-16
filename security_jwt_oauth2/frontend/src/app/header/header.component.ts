import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {GoogleLoginProvider, SocialAuthService} from "@abacritt/angularx-social-login";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  isLogin?: boolean
  loginSub = new Subscription()

  constructor(private authService: AuthService,
              private router: Router,
              private socialAuthService: SocialAuthService) {

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
    this.socialAuthService.signOut(true).then();
    sessionStorage.removeItem('userData')
    localStorage.removeItem('userData')
    this.router.navigate(['/home']).finally()
  }
}
