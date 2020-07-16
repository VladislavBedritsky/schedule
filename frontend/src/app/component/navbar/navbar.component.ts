import { Component, OnInit, HostListener } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  @HostListener('window:scroll', ['$event'])
  onWindowScroll(e) {
        let elToolbar = document.querySelector('nav');

        if (window.pageYOffset > elToolbar.clientHeight) {
          elToolbar.classList.add('navbar-inverse');
        } else {
          elToolbar.classList.remove('navbar-inverse');
        }
  }

}
