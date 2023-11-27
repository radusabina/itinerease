import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbDateStruct, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { IAttraction } from '../dtos/IAttraction';

@Component({
    selector: 'app-itinerary-details-page',
    standalone: true,
    imports: [CommonModule, FormsModule, NgbModule],
    templateUrl: './itinerary-details-page.component.html',
    styleUrl: './itinerary-details-page.component.scss',
})
export class ItineraryDetailsPageComponent {
    // Itinerary details
    itineraryName: string | undefined = undefined;
    startDate: NgbDateStruct | undefined = undefined;
    endDate: NgbDateStruct | undefined = undefined;
    budget: number | undefined = undefined;
    numberOfPersons: number | undefined = undefined;

    // Where from details
    whereFromCountry: string = '';
    whereFromCity: string = '';

    // Where to details
    whereToCountry: string = '';
    whereToCity: string = '';

    // Transport details
    transportType: string = '';
    transportPrice: number | undefined = undefined;

    // Accommodation details
    accommodationName: string | undefined = undefined;
    accommodationAddress: string | undefined = undefined;
    accommodationPrice: number | undefined = undefined;

    // Attraction details
    attractionName: string | undefined = undefined;
    attractionPrice: number | undefined = undefined;
    attractions: IAttraction[] | undefined = undefined;

    minDate: NgbDateStruct;

    countryCities: { [key: string]: string[] } = {
        Romania: ['Cluj', 'Bucuresti', 'Timisoara', 'Iasi', 'Constanta'],
        Germany: ['Berlin', 'Hamburg', 'Munich', 'Cologne', 'Frankfurt'],
        USA: ['New York', 'Los Angeles', 'Chicago', 'Houston', 'Miami'],
        France: ['Paris', 'Marseille', 'Lyon', 'Toulouse', 'Nice'],
        Spain: ['Madrid', 'Barcelona', 'Valencia', 'Seville', 'Bilbao'],
        Italy: ['Rome', 'Milan', 'Venice', 'Florence', 'Naples'],
        Japan: ['Tokyo', 'Osaka', 'Kyoto', 'Hiroshima', 'Nagoya'],
    };

    constructor(private router: Router) {
        this.attractions = [
            { id: 1, id_location: 1, name: 'Muzeul de Artă', price: 20 },
            { id: 2, id_location: 1, name: 'Parcul Central', price: 10 },
            { id: 3, id_location: 1, name: 'Muzeul de Artă', price: 20 },
            { id: 4, id_location: 1, name: 'Parcul Central', price: 10 },
        ];

        const currentDate = new Date();
        this.minDate = {
            year: currentDate.getFullYear(),
            month: currentDate.getMonth() + 1,
            day: currentDate.getDate(),
        };
    }

    onStartDateSelect(date: NgbDateStruct) {
        this.startDate = date;
    }

    onEndDateSelect(date: NgbDateStruct) {
        this.endDate = date;
    }

    onSaveItinerary() {
        this.router.navigate(['homepage']);
    }

    onCountryChangeLeft() {
        const selectedCities = this.countryCities[this.whereFromCountry];
        if (selectedCities) {
            return selectedCities;
        }
        return [];
    }

    onCountryChangeRight() {
        const selectedCities = this.countryCities[this.whereToCountry];
        if (selectedCities) {
            return selectedCities;
        }
        return [];
    }
}
