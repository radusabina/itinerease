import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HomepageComponent } from '../homepage/homepage.component';
import { Router } from '@angular/router';
import { UserService } from '../services/user-service/user.service';
import { IUserLogin } from '../dtos/IUserLogin';
import { HttpClientModule } from '@angular/common/http';
import { IUser } from '../dtos/IUser';

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
    errorMessage: string = '';
    user: IUser | undefined;
    constructor(
        private router: Router,
        private userService: UserService,
    ) {}
    ngOnInit(): void {}

    togglePasswordVisibility(): void {
        this.hidePassword = !this.hidePassword;
    }

    login() {
        var userLoginData: IUserLogin = {
            email: this.email,
            password: this.password,
        };
        this.userService.getLoggedUserDetails(userLoginData).subscribe(
            (user: IUser) => {
                this.user = user;
                this.router.navigate(['/homepage']);
            },
            (error) => {
                if (error.error instanceof ErrorEvent) {
                    this.errorMessage =
                        'Connection error. Please refresh the page and try again';
                } else {
                    this.errorMessage = error.error.message;
                }
            },
        );
    }
}
