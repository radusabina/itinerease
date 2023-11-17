package com.example.itinereasebackend.repository;


import com.example.itinereasebackend.api.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccommodationRepository extends JpaRepository<Accommodation, Integer>{

}
