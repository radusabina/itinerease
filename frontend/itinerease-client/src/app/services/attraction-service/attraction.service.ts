import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { endpointAPI } from '../../config/appconfig';
import { IAttraction } from '../../dtos/IAttraction';
import { IAttractionAdd } from '../../dtos/IAttractionAdd';

@Injectable({
    providedIn: 'root',
})
export class AttractionService {
    constructor(private http: HttpClient) {}

    addAttraction(attraction: IAttractionAdd) {
      return this.http.post(endpointAPI + 'attraction', attraction);
    }

    deleteAttractionById(id: number) {
        return this.http.delete(endpointAPI + `attraction/${id}`);
    }

    updateAttraction(updatedAttraction: IAttraction) {
        return this.http.put<IAttraction>(endpointAPI + 'attraction', updatedAttraction);
    }
}
