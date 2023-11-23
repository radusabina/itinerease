package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transport", schema = "public")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Positive
    @Column(name = "price")
    private float price;

    @JsonIgnore
    @OneToOne(mappedBy = "transport", cascade = CascadeType.ALL)
    private Itinerary itinerary;
}
