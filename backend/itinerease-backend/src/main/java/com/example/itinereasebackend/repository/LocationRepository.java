package com.example.itinereasebackend.repository;

import com.example.itinereasebackend.api.model.Location;
import com.example.itinereasebackend.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location, Integer>{
    Optional<Location> findByCountryAndCity(String country, String city);
}
