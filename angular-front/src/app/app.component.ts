import { Component } from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import {AuthService} from "./_service/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-front';

  is_logged = false;
  private username: string;

  constructor(private cookieService: CookieService,
              private authService: AuthService) {
    this.username = this.cookieService.get('username');
    if (this.username.length > 0) {
      this.is_logged = true;
    } else {
      this.is_logged = false;
    }
  }

  doLogout() {
    this.authService.logout();
  }
}
