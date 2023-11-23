package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "accommodation", schema = "public")
public class Accommodation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Positive
    @Column(name = "price")
    private float price;
}
