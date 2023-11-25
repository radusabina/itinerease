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

    accommodationDetailsName: string = '';
}
