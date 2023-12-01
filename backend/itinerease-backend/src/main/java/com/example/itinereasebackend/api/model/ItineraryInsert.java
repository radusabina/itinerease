package com.example.itinereasebackend.api.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Getter
public class ItineraryInsert {
    private String itineraryName;

    @DateTimeFormat
    @Future
    private LocalDate dateStartModal;

    @DateTimeFormat
    @Future
    private LocalDate dateEndModal;

    @Positive
    private int budget;

    @Positive
    private int selectedPersonsOption;

    private String selectedCountryDestination;
    private String selectedCityDestination;
    private String selectedCountryDeparting;
    private String selectedCityDeparting;

    private String transportType;
    private float transportPrice;

    private String accomodationName;
    private String addressArea;
    private float priceAccomodation;

    private int idUser;

}
