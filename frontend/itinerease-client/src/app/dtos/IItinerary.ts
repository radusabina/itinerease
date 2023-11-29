import { IAccomodation } from './IAccomodation';
import { ILocation } from './ILocation';
import { ITransport } from './ITransport';
import { IUser } from './IUser';
export interface IItinerary {
    id: number;
    arrivalDate: number[];
    budget: number;
    departureDate: number[];
    name: string;
    persons: number;
    accomodation: IAccomodation;
    departure: ILocation;
    destination: ILocation;
    transport: ITransport;
    user: IUser;
}
