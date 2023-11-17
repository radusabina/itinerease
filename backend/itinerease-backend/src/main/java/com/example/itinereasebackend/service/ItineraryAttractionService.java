package com.example.itinereasebackend.service;

import com.example.itinereasebackend.api.model.ItineraryAttraction;
import com.example.itinereasebackend.repository.ItineraryAttractionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItineraryAttractionService {
    @Autowired
    private final ItineraryAttractionRepository _itineraryattractionRepository;

    public void create(ItineraryAttraction itineraryattraction) {
        // TODO validari in cazul in care este necesar
        _itineraryattractionRepository.save(itineraryattraction);
    }
    public List<ItineraryAttraction> getAll(){
        return _itineraryattractionRepository.findAll();
    }

    public Optional<ItineraryAttraction> getById(int itineraryAttractionId) {
        return _itineraryattractionRepository.findById(itineraryAttractionId);
    }

    public void update(int itineraryAttractionId, ItineraryAttraction updatedItineraryAttraction) {
        Optional<ItineraryAttraction> existingItineraryAttraction = _itineraryattractionRepository.findById(itineraryAttractionId);
        if (existingItineraryAttraction.isPresent()) {
            ItineraryAttraction itineraryAttractionToUpdate = existingItineraryAttraction.get();
            _itineraryattractionRepository.save(itineraryAttractionToUpdate);
        } else {
            // TODO Trebuie sa tratam cazul in care nu exista
            throw new RuntimeException("Itinerary Attraction not found with id: " + itineraryAttractionId);
        }
    }

    public void delete(int itineraryAttractionId) {
        // TODO trebuie sa tratam si cazul in care nu exista userul pe care vrem sa il stergem
        _itineraryattractionRepository.deleteById(itineraryAttractionId);
    }

}

