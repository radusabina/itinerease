import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IItineraryInsert } from '../../dtos/IItineraryInsert';
import { endpointAPI } from '../../config/appconfig';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class ItineraryService {
    constructor(private http: HttpClient) {}
    // cu asta ii trimit la topy o cerere prin care vreau sa adaug un itinerar in baza de date
    insertItinerary(itinerary: IItineraryInsert): Observable<IItineraryInsert> {
        return this.http.post<IItineraryInsert>(
            endpointAPI + 'itinerary',
            itinerary,
        );
    }
}
