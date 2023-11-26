import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbDateStruct, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';

@Component({
    selector: 'app-itinerary-details-page',
    standalone: true,
    imports: [CommonModule, FormsModule, NgbModule],
    templateUrl: './itinerary-details-page.component.html',
    styleUrl: './itinerary-details-page.component.scss',
})
export class ItineraryDetailsPageComponent {
    itineraryName: string = 'Itinerary name test';
    startDate: NgbDateStruct = { year: 2023, month: 11, day: 23 };
    endDate: NgbDateStruct = { year: 2023, month: 11, day: 30 };
    budget: number = 6969;
    numberOfPersons: number = 5;
    whereFromCountry: string = 'Germania';
    whereFromCity: string = 'Berlin';
    whereToCountry: string = 'Spania';
    whereToCity: string = 'Barcelona';
    transportType: string = 'Bus';
    transportPrice: number = 15;
    accommodationName: string = 'Hotel Ratatouille';
    accommodationAddress: string = 'Adresa luceafarului 69';
    accommodationPrice: number = 1000;
    attractionName: string = "Turnul Eiffel";
    attractionPrice: number = 20;

    constructor(private router: Router) {
    }

    onStartDateSelect(date: NgbDateStruct) {
        this.startDate = date;
    }

    onEndDateSelect(date: NgbDateStruct) {
        this.endDate = date;
    }

    onSaveItinerary() {
        this.router.navigate('/homepage');
    }
}
