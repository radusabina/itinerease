import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

export interface IItineraryInsert {
    itineraryName: string;
    dateStartModal: NgbDateStruct;
    dateEndModal: NgbDateStruct;
    Budget: number | undefined;
    selectedPersonsOption: number | undefined;
    selectedCountryDesination: string;
    selectedCityDestination: string;
    selectedCountryDeparting: string;
    selectedCityDeparting: string;
    transportType: string;
    transportPrice: number | undefined;
    accomodationName: string;
    addressArea: string;
    PriceTrip: number | undefined;
}
