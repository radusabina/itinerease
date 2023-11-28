import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import {
    NgbAlertModule,
    NgbCalendar,
    NgbDate,
    NgbDatepickerModule,
    NgbDateStruct,
} from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormsModule, Validators } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { IItineraryInsert } from '../dtos/IItineraryInsert';
import { ItineraryService } from '../services/itinerary-service/itinerary.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-modals',
    standalone: true,
    imports: [
        CommonModule,
        RouterOutlet,
        NgbDatepickerModule,
        NgbAlertModule,
        FormsModule,
        JsonPipe,
    ],
    templateUrl: './modals.component.html',
    styleUrl: './modals.component.scss',
})
export class ModalsComponent {
    title = 'itinerease-client';

    dateStartModal!: NgbDateStruct;
    dateEndModal!: NgbDateStruct;

    selectedCountryDesination: string = '';
    selectedCityDestination: string = '';

    selectedCountryDeparting: string = '';
    selectedCityDeparting: string = '';

    itinerary: IItineraryInsert | undefined;

    itineraryName: string = '';
    Budget: number | undefined;
    selectedPersonsOption: number | undefined;
    accomodationName: string = '';
    addressArea: string = '';
    PriceTrip: number | undefined;
    minDateStart: NgbDateStruct;
    minDateEnd: NgbDateStruct;

    // Transport details
    transportType: string = '';
    transportPrice: number | undefined;

    //constructor
    constructor(
        private router: Router,
        private itineraryService: ItineraryService,
        private route: ActivatedRoute,
    ) {
        const currentDate = new Date();
        this.minDateStart = {
            year: currentDate.getFullYear(),
            month: currentDate.getMonth() + 1,
            day: currentDate.getDate(),
        };
        this.minDateEnd = {
            year: currentDate.getFullYear(),
            month: currentDate.getMonth() + 1,
            day: currentDate.getDate() + 1,
        };
    }

    ngOnInit(): void {}

    insertItinerary(): void {
        var itinerary: IItineraryInsert = {
            itineraryName: this.itineraryName,
            dateStartModal: this.dateStartModal,
            dateEndModal: this.dateEndModal,
            Budget: this.Budget,
            selectedPersonsOption: this.selectedPersonsOption,
            selectedCountryDesination: this.selectedCountryDesination,
            selectedCityDestination: this.selectedCityDestination,
            selectedCountryDeparting: this.selectedCountryDeparting,
            selectedCityDeparting: this.selectedCityDeparting,
            transportType: this.transportType,
            transportPrice: this.transportPrice,
            accomodationName: this.accomodationName,
            addressArea: this.addressArea,
            PriceTrip: this.PriceTrip,
        };

        this.itineraryService.insertItinerary(itinerary).subscribe(
            (response: any) => {
                //ce vr sa fac dupa ce o raspuns topy la telefon in cazul pozitiv , da?
                // in cazul pozitiv in care itinerarul e valid
            },
            (error: any) => {
                //ce se intampla in caz de eroareeeeeee :(
                //daca userul nu baga bine datele sau e ceva eroare
            },
        );
    }
    // Obiect care mapează țările la listele lor de orașe
    countryCities: { [key: string]: string[] } = {
        Romania: ['Cluj', 'Bucuresti', 'Timisoara', 'Iasi', 'Constanta'],
        Germany: ['Berlin', 'Hamburg', 'Munich', 'Cologne', 'Frankfurt'],
        USA: ['New York', 'Los Angeles', 'Chicago', 'Houston', 'Miami'],
        France: ['Paris', 'Marseille', 'Lyon', 'Toulouse', 'Nice'],
        Spain: ['Madrid', 'Barcelona', 'Valencia', 'Seville', 'Bilbao'],
        Italy: ['Rome', 'Milan', 'Venice', 'Florence', 'Naples'],
        Japan: ['Tokyo', 'Osaka', 'Kyoto', 'Hiroshima', 'Nagoya'],
        // Adăugați alte țări și orașe aici conform necesităților
    };
    // Functie care returneaza doar orasele din tara selectata
    onCountryDestinationChange() {
        const selectedCities =
            this.countryCities[this.selectedCountryDesination];
        if (selectedCities) {
            // Actualizați lista de orașe pentru țara selectată
            // Această actualizare poate fi făcută direct în HTML fără a adăuga manual opțiunile
            return selectedCities;
        }
        return [];
    }

    // Functie care returneaza doar orasele din tara selectata
    onCountryChangeDeparting() {
        const selectedCities =
            this.countryCities[this.selectedCountryDeparting];
        if (selectedCities) {
            // Actualizați lista de orașe pentru țara selectată
            // Această actualizare poate fi făcută direct în HTML fără a adăuga manual opțiunile
            return selectedCities;
        }
        return [];
    }
}
