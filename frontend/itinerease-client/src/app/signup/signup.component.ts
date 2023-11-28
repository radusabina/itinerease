import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-signup',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './signup.component.html',
    styleUrl: './signup.component.scss',
})
export class SignupComponent {
    hidePassword: boolean = true;
    firstName: string = '';
    lastName: string = '';
    phoneNumber: string = '';
    email: string = '';
    password: string = '';
    confirmPassword: string = '';
    errorMessage: string = '';

    togglePasswordVisibility(): void {
        this.hidePassword = !this.hidePassword;
    }
}
