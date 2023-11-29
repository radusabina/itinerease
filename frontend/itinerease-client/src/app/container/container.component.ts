import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalsComponent } from '../modals/modals.component';
import { UserService } from '../services/user-service/user.service';
import { IUser } from '../dtos/IUser';
import { ItinerariesByUserService } from '../services/itinerary-service/itinerary.service';
@Component({
    selector: 'app-container',
    standalone: true,
    imports: [CommonModule, ModalsComponent],
    templateUrl: './container.component.html',
    styleUrl: './container.component.scss',
})
export class ContainerComponent {
    loggedUser: IUser | undefined;
    itineraries: any[] = [];

    constructor(
        private userService: UserService,
        private itinerariesByUserService: ItinerariesByUserService,
    ) {
        this.loggedUser = this.userService.getLoggedUser();
    }

    ngOnInit() {
        if (this.loggedUser) {
            this.itinerariesByUserService.loadItineraries(this.loggedUser);
            this.itineraries = this.itinerariesByUserService.itineraries;
        }
    }
}
