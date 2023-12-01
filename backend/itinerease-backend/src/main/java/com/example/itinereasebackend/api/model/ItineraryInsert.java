package com.example.itinereasebackend.api.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDate;
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryInsert {
    public String itineraryName;
    public DateStruct dateStartModal;
    public DateStruct dateEndModal;
    public Integer budget;
    public Integer selectedPersonsOption;
    public String selectedCountryDestination;
    public String selectedCityDestination;
    public String selectedCountryDeparting;
    public String selectedCityDeparting;
    public String transportType;
    public Float transportPrice;
    public String accommodationName;
    public String addressArea;
    public Float priceAccommodation;
    public Integer idUser;
    public static class DateStruct {
        public Integer year;
        public Integer month;
        public Integer day;
    }
}

