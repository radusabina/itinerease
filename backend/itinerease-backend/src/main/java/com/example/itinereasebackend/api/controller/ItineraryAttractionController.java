package com.example.itinereasebackend.api.controller;


import com.example.itinereasebackend.api.model.Accommodation;
import com.example.itinereasebackend.api.model.ItineraryAttraction;
import com.example.itinereasebackend.service.AccommodationService;
import com.example.itinereasebackend.service.ItineraryAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItineraryAttractionController {
    @Autowired
    ItineraryAttractionService itineraryAttractionService;



    @GetMapping("/itat")
    public List<ItineraryAttraction> getAll() {
        return itineraryAttractionService.getAll();
    }

}
