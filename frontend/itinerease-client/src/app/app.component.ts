import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { ContainerComponent } from './container/container.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import {
    NgbAlertModule,
    NgbDatepickerModule,
    NgbDateStruct,
} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { AccountPageComponent } from './account-page/account-page.component';
import { ItineraryDetailsPageComponent } from './itinerary-details-page/itinerary-details-page.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RouterLink } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './services/user-service/user.service';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [
        CommonModule,
        RouterOutlet,
        RouterLink,
        ContainerComponent,
        NgbDatepickerModule,
        NgbAlertModule,
        FormsModule,
        JsonPipe,
        NavbarComponent,
        AccountPageComponent,
        ItineraryDetailsPageComponent,
        LoginComponent,
        HomepageComponent,
        SignupComponent,
        HttpClientModule
    ],
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    providers: [UserService],
})
export class AppComponent {
    title = 'itinerease-client';
}
