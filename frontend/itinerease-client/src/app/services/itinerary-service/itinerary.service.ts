import { Injectable } from '@angular/core';
import { IItinerary } from '../../dtos/IItinerary';
import { HttpClient } from '@angular/common/http';
import { endpointAPI } from '../../config/appconfig';
import { Observable } from 'rxjs';
import { UserService } from '../user-service/user.service';
import { IUser } from '../../dtos/IUser';

@Injectable({
    providedIn: 'root',
})
export class ItinerariesByUserService {
    loggedUser: IUser | undefined = undefined;
    itineraries: IItinerary[] = [];

    constructor(
        private http: HttpClient,
        private userService: UserService,
    ) {}

    loadItineraries(loggedUser: IUser): void {
        const userId = loggedUser.id;
        console.log('User ID:', userId);

        if (userId) {
            this.getItinerariesByUser(userId).subscribe(
                (itineraries: IItinerary[]) => {
                    this.itineraries = itineraries;
                },
                (error) => {
                    console.error('Error loading itineraries:', error);
                },
            );
        }
    }

    getItinerariesByUser(userId: number): Observable<IItinerary[]> {
        return this.http.get<IItinerary[]>(
            `${endpointAPI}itineraries-by-user/${userId}`,
        );
    }
}
