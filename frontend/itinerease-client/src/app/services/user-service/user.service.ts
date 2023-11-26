import { Injectable } from '@angular/core';
import { IUserLogin } from '../../dtos/IUserLogin';
import { HttpClient } from '@angular/common/http';
import { IUser } from '../../dtos/IUser';
import { endpointAPI } from '../../config/appconfig';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class UserService {
    constructor(private http: HttpClient) {}

    getLoggedUserDetails(credentials: IUserLogin): Observable<IUser> {
        return this.http.post<IUser>(endpointAPI + 'user/login', credentials);
    }
}
