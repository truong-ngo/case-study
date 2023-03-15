import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {Role} from "../model/role";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Subject, tap} from "rxjs";
import {Registration} from "../model/registration";

const url = environment.apiUrl;

export interface AuthResponse {
  id: string,
  username: string,
  roles: Role[],
  tokenType: string,
  accessToken: string
}

@Injectable()
export class AuthService {
  token?: string
  userChange = new BehaviorSubject<AuthResponse | null>(null);
  usernameSub = new Subject<string[]>();
  emailSub = new Subject<string[]>();

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<AuthResponse>(`${url}/auth/login`, {username: username, password: password})
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
