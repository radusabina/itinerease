//package com.example.itinereasebackend.api.controller;
//
//import com.example.itinereasebackend.api.model.ItineraryAttraction;
//import com.example.itinereasebackend.service.ItineraryAttractionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ItineraryAttractionController {
//    @Autowired
//    ItineraryAttractionService itineraryAttractionService;
//
//    @PostMapping("/itinerary-attraction")
//    public void create(@RequestBody ItineraryAttraction itineraryAttraction) {
//        itineraryAttractionService.create(itineraryAttraction);
//    }
//
//    @GetMapping("/itinerary-attraction")
//    public List<ItineraryAttraction> getAllItineraryAttractions() {
//        return itineraryAttractionService.getAll();
//    }
//
//    @PutMapping("/itinerary-attraction")
//    public void update(@RequestBody ItineraryAttraction itineraryAttraction) {
//        itineraryAttractionService.update(itineraryAttraction.getId(), itineraryAttraction);
//    }
//
//    @DeleteMapping("/itinerary-attraction/{id}")
//    public void delete(@PathVariable int id) {
//        itineraryAttractionService.delete(id);
//    }
//}
