package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "attraction", schema = "public")
public class Attraction{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_location")
    private int id_location;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

}
