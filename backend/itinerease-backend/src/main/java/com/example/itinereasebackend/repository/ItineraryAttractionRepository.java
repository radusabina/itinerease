package com.example.itinereasebackend.repository;

import com.example.itinereasebackend.api.model.ItineraryAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ItineraryAttractionRepository extends JpaRepository<ItineraryAttraction, Integer>{
}
