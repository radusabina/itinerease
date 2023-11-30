import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import {
    NgbAlertModule,
    NgbDatepickerModule,
    NgbDateStruct,
} from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormsModule, Validators } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { IItineraryInsert } from '../dtos/IItineraryInsert';
import { ItineraryService } from '../services/itinerary-service/itinerary.service';
import { Router } from '@angular/router';
import { UserService } from '../services/user-service/user.service';

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

    selectedCountryDestination: string = '';
    selectedCityDestination: string = '';

    selectedCountryDeparting: string = '';
    selectedCityDeparting: string = '';

    itinerary: IItineraryInsert | undefined;

    itineraryName: string = '';
    budget: number | undefined;
    selectedPersonsOption: number | undefined;
    accomodationName: string = '';
    addressArea: string = '';
    priceAccomodation: number | undefined;
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
        private userService: UserService,
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
            day: currentDate.getDate(),
        };
    }

    insertItinerary() {
        var itinerary: IItineraryInsert = {
            itineraryName: this.itineraryName,
            dateStartModal: this.dateStartModal,
            dateEndModal: this.dateEndModal,
            budget: this.budget,
            selectedPersonsOption: this.selectedPersonsOption,
            selectedCountryDestination: this.selectedCountryDestination,
            selectedCityDestination: this.selectedCityDestination,
            selectedCountryDeparting: this.selectedCountryDeparting,
            selectedCityDeparting: this.selectedCityDeparting,
            transportType: this.transportType,
            transportPrice: this.transportPrice,
            accomodationName: this.accomodationName,
            addressArea: this.addressArea,
            priceAccomodation: this.priceAccomodation,
            idUser: this.userService.getLoggedUserId(),
        };

        this.itineraryService.insertItinerary(itinerary).subscribe(
            (response: any) => {
                //ce vr sa fac dupa ce o raspuns topy la telefon in cazul pozitiv , da?
                // in cazul pozitiv in care itinerarul e valid
                //to do de la tudor
                console.log('adaugat cu succes');
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
            this.countryCities[this.selectedCountryDestination];
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
