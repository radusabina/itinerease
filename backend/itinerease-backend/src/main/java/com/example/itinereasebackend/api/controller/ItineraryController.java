package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.*;
import com.example.itinereasebackend.service.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItineraryController {
    @Autowired
    ItineraryService itineraryService;

    @Autowired
    LocationService locationService;

    @Autowired
    UserService userService;

    @Autowired
    AccommodationService accommodationService;

    @Autowired
    TransportService transportService;

    @PostMapping("/itinerary")
    public ResponseEntity<Object> create(@RequestBody Map<String, String> itinerary) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateStartModal = LocalDate.parse(itinerary.get("dateStartModal"), formatter);
        LocalDate dateEndModal = LocalDate.parse(itinerary.get("dateEndModal"), formatter);
        String itineraryName = itinerary.get("itineraryName");
        int budget = Integer.parseInt(itinerary.get("budget"));
        int selectedPersonsOption = Integer.parseInt(itinerary.get("selectedPersonsOption"));
        String selectedCountryDestination = itinerary.get("selectedCountryDestination");
        String selectedCityDestination = itinerary.get("selectedCityDestination");
        String selectedCountryDeparting = itinerary.get("selectedCountryDeparting");
        String selectedCityDeparting = itinerary.get("selectedCityDeparting");
        String transportType = itinerary.get("transportType");
        float transportPrice = Float.parseFloat(itinerary.get("transportPrice"));
        String accommodationName = itinerary.get("accommodationName");
        String addressArea = itinerary.get("addressArea");
        float priceAccommodation = Float.parseFloat(itinerary.get("priceAccommodation"));
        int idUser = Integer.parseInt(itinerary.get("idUser"));


        Location destinationLocation = locationService.getByCountryAndCity(selectedCountryDestination, selectedCityDestination)
                .orElseThrow(() -> new RuntimeException("Destination location not found"));

        Location departureLocation = locationService.getByCountryAndCity(selectedCountryDeparting, selectedCityDeparting)
                .orElseThrow(() -> new RuntimeException("Departure location not found"));

        Accommodation accommodation = new Accommodation(accommodationName, addressArea, priceAccommodation);
        accommodationService.create(accommodation);

        Transport transport = new Transport(transportType,transportPrice);
        transportService.create(transport);

        Itinerary itinerary1 = new Itinerary(destinationLocation, transport, userService.getById(idUser).orElseThrow(() -> new RuntimeException("User not found")), accommodation, departureLocation,
                itineraryName, dateStartModal, dateEndModal, budget, selectedPersonsOption);

        try {
            itineraryService.create(itinerary1);
            Itinerary itineraryFounded = itineraryService.getItineraryByDetails(itinerary1);

            if (itineraryFounded == null) {
                throw new RuntimeException("Itinerary not found");
            }

            return ResponseEntity.ok(itineraryFounded);
        } catch (ConstraintViolationException cve) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Exception(cve.getConstraintViolations()
                    .stream()
                    .findFirst()
                    .map(ConstraintViolation::getMessage)
                    .orElse("Validation failed.")));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EntityNotFoundException(exception.getMessage()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception(exception.getMessage()));
        }
    }


    @PutMapping("/itinerary")
    public void update(@RequestBody Itinerary itinerary) {
        itineraryService.update(Math.toIntExact(itinerary.getId()), itinerary);
    }

    @DeleteMapping("/itinerary/{id}")
    public void delete(@PathVariable Long id) {
        itineraryService.delete(Math.toIntExact(id));
    }

    @GetMapping("/itinerary")
    public List<Itinerary> getAll() {
        return itineraryService.getAll();
    }

    @GetMapping("/itinerary/{id}")
    public ResponseEntity<Object> getItineraryById(@PathVariable int id) {
        try {
            Optional<Itinerary> itineraryOptional = itineraryService.getById(id);

            if (itineraryOptional.isPresent()) {
                Itinerary itinerary = itineraryOptional.get();
                return ResponseEntity.ok(itinerary);
            } else {
                throw new EntityNotFoundException("Itinerary not found");
            }
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @GetMapping("/itineraries-by-user/{userId}")
    public ResponseEntity<List<Itinerary>> getItinerariesByUserId(@PathVariable int userId) {
        List<Itinerary> itineraries = itineraryService.getItinerariesByUserId(userId);
        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }
}
