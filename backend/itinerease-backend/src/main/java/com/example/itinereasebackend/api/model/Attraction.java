package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "attraction", schema = "public")
public class Attraction{
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;

    @Column(name = "name")
    private String name;

    @Positive
    @Column(name = "price")
    private float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "attractions")
    private List<Itinerary> itineraries;
}
