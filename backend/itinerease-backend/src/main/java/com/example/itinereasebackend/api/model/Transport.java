package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
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
    @Column(name = "price")
    private int price;
}
