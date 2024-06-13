import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive} from "@angular/router";
import {MenubarModule} from "primeng/menubar";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive,
    MenubarModule
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {

}
