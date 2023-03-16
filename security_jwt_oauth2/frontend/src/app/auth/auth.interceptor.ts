import {Injectable} from "@angular/core";
import {HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {exhaustMap, take} from "rxjs";
import {SocialUser} from "../model/social-user";
import {AuthResponse} from "../model/auth-response";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    return this.authService.userChange.pipe(take(1), exhaustMap(
      (data: AuthResponse | SocialUser | null) => {
        if (!data) {
          return next.handle(req);
        } else {
          const authReq = req.clone({
            headers: new HttpHeaders().set('Authorization', data.tokenType + ' ' + data.accessToken)
          })
          return next.handle(authReq)
        }
      }
    ))
  }

}
