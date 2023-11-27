import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgbDateStruct, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { IAttraction } from '../dtos/IAttraction';
import { ItineraryService } from '../services/itinerary-service/itinerary.service';
import { IItinerary } from '../dtos/IItinerary';

@Component({
    selector: 'app-itinerary-details-page',
    standalone: true,
    imports: [CommonModule, FormsModule, NgbModule],
    templateUrl: './itinerary-details-page.component.html',
    styleUrl: './itinerary-details-page.component.scss',
})
export class ItineraryDetailsPageComponent {
    itinerary: IItinerary | undefined = undefined;

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

    constructor(private router: Router, private itineraryService: ItineraryService) {
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

    getItineraryById(id: number) {
        this.itineraryService.getItineraryById(id).subscribe(
            (response: any) => {
                this.itinerary = {
                    id: response.id,
                    id_departure: response.departure_location.id,
                    departure_country: response.departure_location.country,
                    departure_city: response.departure_location.city,
                    id_destination: response.destination_location.id,
                    destination_country: response.destination_location.country,
                    destination_city: response.destination_location.city,
                    id_transport: response.transport.id,
                    transport_type: response.transport.type,
                    transport_price: response.transport.price,
                    id_user: response.user.id,
                    id_accommodation: response.accommodation.id,
                    accommodation_name: response.accommodation.name,
                    accommodation_address: response.accommodation.address,
                    accommodation_price: response.accommodation.price,
                    attractions: response.attractions,
                    arrival_date: new Date(response.arrival_date[0], response.arrival_date[1] - 1, response.arrival_date[2]),
                    departure_date: new Date(response.departure_date[0], response.departure_date[1] - 1, response.departure_date[2]),
                    budget: response.budget,
                    persons: response.persons
                };
                console.log(this.itinerary);
            },
            (error) => {
                console.log(error);
            }
        );
    }
}
