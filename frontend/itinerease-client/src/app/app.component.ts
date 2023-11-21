import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ContainerComponent } from './container/container.component';
import { NavbarComponent } from './navbar/navbar.component';

import {
    NgbAlertModule,
    NgbDatepickerModule,
    NgbDateStruct,
} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { AccountPageComponent } from './account-page/account-page.component';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    imports: [
        CommonModule,
        RouterOutlet,
        ContainerComponent,
        NgbDatepickerModule,
        NgbAlertModule,
        FormsModule,
        JsonPipe,
        NavbarComponent,
        AccountPageComponent,
    ],
})
export class AppComponent {
    title = 'itinerease-client';
    dataStartModel!: NgbDateStruct;
    dateEndModel!: NgbDateStruct;
}
