package com.example.itinereasebackend.service;

import com.example.itinereasebackend.api.model.*;
import com.example.itinereasebackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccommodationService {
    @Autowired
    private final AccommodationRepository accommodationRepository;

    public void create(Accommodation accm) {
        // TODO validari in cazul in care este necesar
        accommodationRepository.save(accm);
    }
    public List<Accommodation> getAll(){
        return accommodationRepository.findAll();
    }

    public Optional<Accommodation> getById(int userId) {
        return accommodationRepository.findById(userId);
    }

    public void update(int accmId, Accommodation updatedAccm) {
        Optional<Accommodation> existingAccm = accommodationRepository.findById(accmId);
        if (existingAccm.isPresent()) {
            Accommodation accmToUpdate = existingAccm.get();
            accmToUpdate.setAddress(updatedAccm.getAddress());
            accmToUpdate.setName(updatedAccm.getName());
            accmToUpdate.setPrice(updatedAccm.getPrice());
            accommodationRepository.save(updatedAccm);
        } else {
            // TODO Trebuie sa tratam cazul in care nu exista
            throw new RuntimeException("Accommodation not found with id: " + accmId);
        }
    }

    public void delete(int userId) {
        // TODO trebuie sa tratam si cazul in care nu exista userul pe care vrem sa il stergem
        accommodationRepository.deleteById(userId);
    }

}

