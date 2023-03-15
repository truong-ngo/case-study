import {AfterViewInit, Component, ElementRef, OnInit} from '@angular/core';
import {AuthService} from "./auth/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  title = 'frontend';

  constructor(private authService: AuthService, private element: ElementRef) {
  }

  ngOnInit() {
    this.authService.autologin();
  }

  ngAfterViewInit() {

  }



}
