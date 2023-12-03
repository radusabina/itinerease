package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "attraction", schema = "public")
public class Attraction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_location")
    @NotNull(message = "Location cannot be null")
    private Location location;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Try again! Name must start with an uppercase letter")
    private String name;

    @Column(name = "price")
    @Positive(message = "Price must be a positive number")
    private float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "attractions")
    private List<Itinerary> itineraries;


    private Integer itineraryId;
    @Override
    public String toString() {
        return '{' +
                "id=" + id +
                ", location=" + location +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
