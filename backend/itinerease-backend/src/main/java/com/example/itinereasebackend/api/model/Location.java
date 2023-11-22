package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "location", schema = "public")
public class Location{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attraction> attractions;

    @JsonIgnore
    @OneToMany(mappedBy = "destination_location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itinerary> destination_itineraries;

    @JsonIgnore
    @OneToMany(mappedBy = "departure_location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Itinerary> departure_itineraries;

}
