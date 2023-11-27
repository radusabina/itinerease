import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IItinerary } from '../../dtos/IItinerary';
import { endpointAPI } from '../../config/appconfig';

@Injectable({
    providedIn: 'root',
})
export class ItineraryService {
    constructor(private http: HttpClient) {}

    getItineraryById(id: number) {
        return this.http.get<IItinerary>(endpointAPI + `itinerary/${id}`);
    }
}
