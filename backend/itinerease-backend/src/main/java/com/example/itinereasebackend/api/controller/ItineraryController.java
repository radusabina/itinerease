package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.Itinerary;
import com.example.itinereasebackend.service.ItineraryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItineraryController {
    @Autowired
    ItineraryService itineraryService;

    @PostMapping("/itinerary")
    public void create(@RequestBody Itinerary itinerary) {
        itineraryService.create(itinerary);
    }

    @PutMapping("/itinerary")
    public void update(@RequestBody Itinerary itinerary) {
        itineraryService.update(itinerary.getId(), itinerary);
    }

    @DeleteMapping("/itinerary/{id}")
    public void delete(@PathVariable int id) {
        itineraryService.delete(id);
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






}
