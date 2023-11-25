package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.*;


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
    @NotBlank(message = "Name cannot be blank")
    @Length(max = 255, message = "Name is too long")
    private String name;

    @Column(name = "address")
    @NotBlank(message = "Address cannot be blank")
    @Length(max = 255, message = "Address is too long")
    private String address;

    @Positive(message = "Price must be a positive number")
    @Column(name = "price")
    private float price;

    @JsonIgnore
    @OneToOne(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private Itinerary itinerary;
}
