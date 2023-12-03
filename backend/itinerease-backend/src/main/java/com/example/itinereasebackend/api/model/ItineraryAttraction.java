package com.example.itinereasebackend.api.model;

import com.example.itinereasebackend.api.model.Attraction;
import com.example.itinereasebackend.api.model.Itinerary;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        private int itinerary_Id;

        @Column(name = "id_attraction")
        private int attractionId;

        // Constructori, hashCode, equals, getteri și setteri
    }

    @EmbeddedId
    private ItineraryAttractionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itineraryId")
    @JoinColumn(name = "id_itinerary")
    private Itinerary itinerary;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("attractionId")
    @JoinColumn(name = "id_attraction")
    private Attraction attraction;

    // Constructori, getteri și setteri
}
