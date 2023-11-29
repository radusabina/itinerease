import { TestBed } from '@angular/core/testing';

import { ItinerariesByUserService } from './itinerary.service';

describe('ItinerariesByUserService', () => {
    let service: ItinerariesByUserService;

    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(ItinerariesByUserService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
