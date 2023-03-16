import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Subject, tap} from "rxjs";
import {Registration} from "../model/registration";
import {SocialUser} from "../model/social-user";
import {AuthResponse} from "../model/auth-response";

const url = environment.apiUrl;

@Injectable()
export class AuthService {
  token?: string
  userChange = new BehaviorSubject<AuthResponse | SocialUser | null>(null);
  usernameSub = new Subject<string[]>();
  emailSub = new Subject<string[]>();

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<AuthResponse>(`${url}/auth/login`, {username: username, password: password})
  }

  googleLogin(user: SocialUser) {
    return this.http.post<SocialUser>(`${url}/auth/google-login`, user);
  }

  register(register: Registration) {
    return this.http.post<any>(`${url}/auth/register`, register)
  }

  getUsername() {
    return this.http.get<string[]>(`${url}/auth/username`).pipe(tap(
      data => {
        this.usernameSub.next(data);
      }
    ))
  }

  getEmail() {
    return this.http.get<string[]>(`${url}/auth/email`).pipe(tap(
      data => {
        this.emailSub.next(data)
      }
    ))
  }

  autologin() {
    const userNormal = sessionStorage.getItem('userData')
    const userRemember = localStorage.getItem('userData')
    if (!userNormal && !userRemember) {
      return;
    }
    let user
    if (!!userNormal) {
      user = JSON.parse(userNormal)
    } else if (!!userRemember) {
      user = JSON.parse(userRemember)
    }
    this.userChange.next(user)
  }
}
