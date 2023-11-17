package com.example.itinereasebackend.repository;

import com.example.itinereasebackend.api.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository  extends JpaRepository<Transport, Integer> {
}
