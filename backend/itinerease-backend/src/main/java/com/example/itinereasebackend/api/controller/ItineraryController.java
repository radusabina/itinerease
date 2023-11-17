package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.Itinerary;
import com.example.itinereasebackend.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
