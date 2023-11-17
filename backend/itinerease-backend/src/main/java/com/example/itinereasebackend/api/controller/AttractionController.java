package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.Attraction;
import com.example.itinereasebackend.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttractionController {
    @Autowired
    AttractionService attractionService;

    @PostMapping("/attraction")
    public void create(@RequestBody Attraction attraction) {
        attractionService.create(attraction);
    }

    @GetMapping("/attraction")
    public List<Attraction> getAllAttractions() {
        return attractionService.getAll();
    }

    @PutMapping("/attraction")
    public void update(@RequestBody Attraction attraction) {
        attractionService.update(attraction.getId(), attraction);
    }

    @DeleteMapping("/attraction/{id}")
    public void delete(@PathVariable int id) {
        attractionService.delete(id);
    }
}
