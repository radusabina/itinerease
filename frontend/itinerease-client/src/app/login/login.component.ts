import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
    FormsModule,
    FormGroup,
    FormControl,
    Validators,
} from '@angular/forms';
import { HomepageComponent } from '../homepage/homepage.component';
import { Router } from '@angular/router';
import { clear } from 'console';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [CommonModule, FormsModule, HomepageComponent],
    templateUrl: './login.component.html',
    styleUrl: './login.component.scss',
})
export class LoginComponent {
    hidePassword: boolean = true;
    password: string = '';
    email: string = '';
    constructor(private router: Router) {}
    ngOnInit(): void {}

    togglePasswordVisibility(): void {
        this.hidePassword = !this.hidePassword;
    }

    navigateToHomepage() {
        this.router.navigate(['/homepage']);
    }
}
