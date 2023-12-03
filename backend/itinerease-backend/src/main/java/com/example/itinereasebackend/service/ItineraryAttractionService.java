package com.example.itinereasebackend.service;

import com.example.itinereasebackend.api.model.ItineraryAttraction;
import com.example.itinereasebackend.repository.ItineraryAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryAttractionService {

    @Autowired
    private ItineraryAttractionRepository _itineraryAttractionRepository;

    public void create(ItineraryAttraction itineraryAttraction) {
        // TODO validari in cazul in care este necesar
        _itineraryAttractionRepository.save(itineraryAttraction);
    }

    public List<ItineraryAttraction> getAll(){
        return _itineraryAttractionRepository.findAll();
    }
}
