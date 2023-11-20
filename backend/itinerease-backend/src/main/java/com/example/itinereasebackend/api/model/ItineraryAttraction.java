//package com.example.itinereasebackend.api.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Table(name = "itinerary_attraction", schema = "public")
//public class ItineraryAttraction{
//    @EmbeddedId
//    private ItineraryAttractionId id;
//
//    @ManyToOne
//    @MapsId("id_itinerary")
//    @JoinColumn(name = "id_itinerary")
//    private Itinerary itinerary;
//
//    @ManyToOne
//    @MapsId("id_attraction")
//    @JoinColumn(name = "id_attraction")
//    private Attraction attraction;
//
////    @Id
////    @Column(name = "id_itinerary")
////    private int id_itinerary;
////
////    @Column (name = "id_attraction")
////    private int id_attraction;
//
//}
