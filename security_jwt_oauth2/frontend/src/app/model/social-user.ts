import {Role} from "./role";

export class SocialUser {
  email?: string;
  idToken?: string
  tokenType?: string;
  accessToken?: string;
  roles?: Role[];
}
