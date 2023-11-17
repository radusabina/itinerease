package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "accommodation", schema = "public")
public class Accommodation{
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private String price;
}
