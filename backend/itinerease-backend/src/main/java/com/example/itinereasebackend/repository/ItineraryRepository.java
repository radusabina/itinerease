package com.example.itinereasebackend.repository;

import com.example.itinereasebackend.api.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.*;

@RepositoryRestResource
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {
    List<Itinerary> findByUser_Id(int userId);
}
