package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToOne(mappedBy = "accommodation", cascade = CascadeType.MERGE)
    private Itinerary itinerary;


    @Override
    public String toString() {
        return '{' +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                '}';}

    public Accommodation(String accomodationName, String addressArea, float priceAccommodation) {
        this.address = addressArea;
        this.name = accomodationName;
        this.price = priceAccommodation;

    }
}
