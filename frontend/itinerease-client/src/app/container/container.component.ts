import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalsComponent } from '../modals/modals.component';
import { UserService } from '../services/user-service/user.service';
import { IUser } from '../dtos/IUser';

@Component({
    selector: 'app-container',
    standalone: true,
    imports: [CommonModule, ModalsComponent],
    templateUrl: './container.component.html',
    styleUrl: './container.component.scss',
})
export class ContainerComponent {
    loggedUser: IUser | undefined;
    constructor(private userService: UserService) {
        this.loggedUser = this.userService.getLoggedUser();
    }
}
