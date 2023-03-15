import {Component, OnInit} from '@angular/core';
import {
  faFacebookF,
  faGooglePlusG,
} from "@fortawesome/free-brands-svg-icons";
import {
  FormBuilder,
  FormControl,
  ValidationErrors,
  Validators
} from "@angular/forms";
import {AuthService} from "./auth.service";
import {Router} from "@angular/router";
import {map, Observable} from "rxjs";
import {Registration} from "../model/registration";


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  rememberMe?: string;
  username?: string[];
  email?: string[]

  isLogin = true
  faFacebook = faFacebookF
  faGoogle = faGooglePlusG
  loginForm = this.formBuilder.group({
    username: ['', {validators: [Validators.required, Validators.minLength(6)], updateOn: "blur"}],
    password: ['', {validators: [Validators.required, Validators.minLength(6)], updateOn: "blur"}],
  })

  registerForm = this.formBuilder.group({
     username: ['', {
       validators: [Validators.required, Validators.minLength(6), this.existUsernameValidator.bind(this)],
       // asyncValidators: [this.asyncUsernameValidator.bind(this)],
       updateOn: "blur"
     }],
     password: ['', {validators: [Validators.required, Validators.minLength(6)], updateOn: "blur"}],
     confirmPassword: ['', {validators: [Validators.required, this.confirmPassValidator.bind(this)], updateOn: "blur"}],
     email: ['', {
       validators: [Validators.required, Validators.email, this.existEmailValidator.bind(this)],
       // asyncValidators: [this.asyncEmailValidator.bind(this)],
       updateOn: "blur"
     }],
  })

  constructor(private authService: AuthService,
              private router: Router,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.registerForm.controls.password.valueChanges.subscribe(
      () => {
        this.registerForm.controls.confirmPassword.updateValueAndValidity();
      }
    )
    this.authService.getUsername().subscribe();
    this.authService.getEmail().subscribe();
    this.authService.usernameSub.subscribe(
      data => {
        this.username = data
      }
    )
    this.authService.emailSub.subscribe(
      data => {
        this.email = data
      }
    )
  }

  switchToRegister() {
    this.isLogin = false
  }

  switchToLogin() {
    this.isLogin = true
  }

  login() {
    if (!this.loginForm.valid) {
      Object.keys(this.loginForm.controls).forEach(field => {
        const control = this.loginForm.get(field);
        control?.markAsTouched({ onlySelf: true });
      });
      return
    }
    const username = this.loginForm.value.username as string
    const password = this.loginForm.value.password as string
    this.authService.login(username, password).subscribe(
      (data) => {
        this.authService.userChange.next(data);
        if (this.rememberMe) {
          localStorage.setItem('userData', JSON.stringify(data))
        } else {
          sessionStorage.setItem('userData', JSON.stringify(data))
        }
        this.router.navigate(['/products']).finally()
      }, error => {
        console.log(error)
      }
    )
  }

  createAccount() {
    console.log(this.registerForm)
    if (this.registerForm.invalid) {
      Object.keys(this.registerForm.controls).forEach(field => {
        const control = this.registerForm.get(field);
        control?.markAsTouched({ onlySelf: true });
      });
    } else {
      let username = this.registerForm.get('username')?.value as string;
      let password = this.registerForm.get('password')?.value as string;
      let email = this.registerForm.get('email')?.value as string;
      let register = new Registration(username, password, email);
      this.authService.register(register).subscribe(
        () => {
          alert('Register successfully')
          this.registerForm.reset()
          this.router.navigate(['/home']).finally()
        }, () => {
          alert('Register failed')
        }
      )
    }
  }

  confirmPassValidator(control: FormControl): {[s: string]: boolean} | null {
    // @ts-ignore
    if (control.value !== '' && control.value !== control?.parent?.controls?.['password']?.value) {
      return {'notMatch': true};
    }
    return null
  }

  clearValid(event: Event, messDiv: HTMLDivElement) {
    let input = event.target as HTMLInputElement
    input.classList.add('clear')
    messDiv.classList.add('hide')
  }

  checkValid(event: Event, messDiv: HTMLDivElement) {
    let input = event.target as HTMLInputElement
    input.classList.remove('clear')
    messDiv.classList.remove('hide')
  }

  existUsernameValidator(control: FormControl): {[s: string]: boolean} | null {
    if (this.username?.includes(control.value)) {
      return {'usernameExist': true}
    }
    return null;
  }

  existEmailValidator(control: FormControl): {[s: string]: boolean} | null {
    if (this.email?.includes(control.value)) {
      return {'emailExist': true}
    }
    return null;
  }

  asyncUsernameValidator(control: FormControl): Observable<ValidationErrors | null> | Promise<ValidationErrors | null> {
    return this.authService.getUsername().pipe(map(
      data => {
        if (data.includes(control.value)) {
          return {'usernameExist': true}
        }
        return null;
      }
    ))
  }

  asyncEmailValidator(control: FormControl): Observable<ValidationErrors | null> | Promise<ValidationErrors | null> {
    return this.authService.getEmail().pipe(map(
      data => {
        if (data.includes(control.value)) {
          return {'emailExist': true}
        }
        return null;
      }
    ))
  }
}


