package com.example.itinereasebackend.repository;


import com.example.itinereasebackend.api.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AccommodationRepository extends JpaRepository<Accommodation, Integer>{
    Optional<Accommodation> findByName(String name);
}
