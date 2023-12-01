package com.example.itinereasebackend.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank(message = "Type cannot be blank")
    @Length(max = 255, message = "Type is too long")
    @Pattern(regexp = "Bus|Train|Car|Airplane|Boat", message = "Type must be: Bus, Train, Car, Airplane or Boat")

    private String type;

    @Positive(message = "Price must be a positive number")
    @Column(name = "price")
    private float price;

    @JsonIgnore
    @OneToOne(mappedBy = "transport", cascade = CascadeType.MERGE)
    private Itinerary itinerary;

    @Override
    public String toString() {
        return '{' +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';}

    public Transport(String transportType, float transportPrice) {
        this.type = transportType;
        this.price = transportPrice;

    }
}
