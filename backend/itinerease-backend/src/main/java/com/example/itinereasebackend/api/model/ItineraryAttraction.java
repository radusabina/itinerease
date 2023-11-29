package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itinerary_attraction", schema = "public")
public class ItineraryAttraction {

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItineraryAttractionId implements Serializable {
        @Column(name = "id_itinerary")
        private int itineraryId;

        @Column(name = "id_attraction")
        private int attractionId;

        // Constructori, hashCode, equals, getteri și setteri
    }

    @EmbeddedId
    private ItineraryAttractionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itineraryId")
    @JoinColumn(name = "id_itinerary", referencedColumnName = "id")
    private Itinerary itinerary;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("attractionId")
    @JoinColumn(name = "id_attraction", referencedColumnName = "id")
    private Attraction attraction;

    // Constructori, getteri și setteri
}
