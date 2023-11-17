package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import lombok.*;


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


}
