package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itinerary_attraction", schema = "public")
public class ItineraryAttraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_itinerary", referencedColumnName = "id")
    private Itinerary itinerary;

    @ManyToOne
    @JoinColumn(name = "id_attraction", referencedColumnName = "id")
    private Attraction attraction;

}
