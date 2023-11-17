package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itinerary", schema = "public")
public class Itinerary {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_destination")
    private int id_destination;

    @Column(name = "id_transport")
    private int id_transport;

    @Column(name = "id_user")
    private int id_user;

    @Column(name = "id_accommodation")
    private int id_accommodation;

    @Column(name = "id_departure")
    private int id_departure;

    @Column(name = "name")
    private String name;

    @DateTimeFormat
    @Column(name = "departure_date")
    private LocalDate departure_date;

    @DateTimeFormat
    @Column(name = "arrival_date")
    private LocalDate arrival_date;

    @Positive
    @Column(name = "budget")
    private int budget;

    @Positive
    @Column(name = "persons")
    private int persons;
}
