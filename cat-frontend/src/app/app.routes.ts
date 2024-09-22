import {Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AboutComponent} from "./about/about.component";
import {ContactComponent} from "./contact/contact.component";
import {PageNotFoundComponent} from "./core/page-not-found/page-not-found.component";
import {LoginComponent} from "./login/login.component";

export const routes: Routes = [
  {'path': 'home',title: 'Anasayfa', component: HomeComponent},
  {'path': 'about',title: 'Hakkımızda', component: AboutComponent},
  {'path': 'contact', title: 'İletişim', component: ContactComponent},
  {'path': 'login', title: 'Login', component: LoginComponent},
  {'path': '', redirectTo: '/home', pathMatch: 'full'},
  {'path': '**', component: PageNotFoundComponent}
];
