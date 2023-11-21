package com.example.itinereasebackend.api.model;

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
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Positive
    @Column(name = "price")
    private float price;
}
