import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import {
    NgbAlertModule,
    NgbDatepickerModule,
    NgbDateStruct,
} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { JsonPipe } from '@angular/common';

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
    dataStartModel!: NgbDateStruct;
    dateEndModel!: NgbDateStruct;

    selectedCountry: string = '';
    selectedCity: string = '';

    selectedCountry2: string = '';
    selectedCity2: string = '';

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

    onCountryChange() {
        const selectedCities = this.countryCities[this.selectedCountry];
        if (selectedCities) {
            // Actualizați lista de orașe pentru țara selectată
            // Această actualizare poate fi făcută direct în HTML fără a adăuga manual opțiunile
            return selectedCities;
        }
        return [];
    }
    onCountryChange2() {
        const selectedCities = this.countryCities[this.selectedCountry2];
        if (selectedCities) {
            // Actualizați lista de orașe pentru țara selectată
            // Această actualizare poate fi făcută direct în HTML fără a adăuga manual opțiunile
            return selectedCities;
        }
        return [];
    }
}
