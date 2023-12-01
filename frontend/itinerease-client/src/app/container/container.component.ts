import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalsComponent } from '../modals/modals.component';
import { UserService } from '../services/user-service/user.service';
import { IUser } from '../dtos/IUser';
import { ItineraryService } from '../services/itinerary-service/itinerary.service';
import { IItineraryHomepage } from '../dtos/IItineraryHomepage';

@Component({
    selector: 'app-container',
    standalone: true,
    imports: [CommonModule, ModalsComponent],
    templateUrl: './container.component.html',
    styleUrl: './container.component.scss',
})
export class ContainerComponent {
    loggedUser: IUser | undefined;
    itineraries: IItineraryHomepage[] = [];
    cities: any[] = [];

    constructor(
        private userService: UserService,
        private itineraryService: ItineraryService,
    ) {}

    ngOnInit() {
        this.loggedUser = this.userService.getLoggedUser();
        if (this.loggedUser) {
            this.itineraryService.loadItineraries(this.loggedUser);
            this.itineraryService.itineraries$.subscribe(
                (itineraries) => {
                    this.itineraries = itineraries;
                    console.log(this.itineraries);
                },
                (error) => {
                    console.error('Error loading itineraries:', error);
                },
            );
        }
    }

    calculateDaysBetweenDates(arrivalDate: Date, departureDate: Date): number {
        const oneDay = 24 * 60 * 60 * 1000; // hours * minutes * seconds * milliseconds

        const arrivalTime = arrivalDate.getTime();
        const departureTime = departureDate.getTime();

        const differenceInDays = Math.round(
            Math.abs((arrivalTime - departureTime) / oneDay),
        );

        return differenceInDays;
    }

    calculateDays(itinerary: IItineraryHomepage): number {
        const arrivalDate = new Date(
            itinerary.arrivalDate[0],
            itinerary.arrivalDate[1] - 1,
            itinerary.arrivalDate[2],
        );
        const departureDate = new Date(
            itinerary.departureDate[0],
            itinerary.departureDate[1] - 1,
            itinerary.departureDate[2],
        );

        return this.calculateDaysBetweenDates(arrivalDate, departureDate);
    }
}
