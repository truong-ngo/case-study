import {Role} from "./role";

export class AuthResponse {
  id?: string;
  username?: string;
  roles?: Role[];
  tokenType?: string;
  accessToken?: string
}
