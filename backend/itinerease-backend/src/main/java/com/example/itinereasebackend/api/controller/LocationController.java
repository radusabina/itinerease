package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.Location;
import com.example.itinereasebackend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {
    @Autowired
    LocationService locationService;

    @PostMapping("/location")
    public void create(@RequestBody Location location) {
        locationService.create(location);
    }

    @GetMapping("/location")
    public List<Location> getAllLocations() {
        return locationService.getAll();
    }

    @PutMapping("/location")
    public void update(@RequestBody Location location) {
        locationService.update(location.getId(), location);
    }

    @DeleteMapping("/location/{id}")
    public void delete(@PathVariable int id) {
        locationService.delete(id);
    }
}
