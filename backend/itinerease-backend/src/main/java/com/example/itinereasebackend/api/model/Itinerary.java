package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itinerary", schema = "public")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_destination", referencedColumnName = "id")
    private Location destination_location;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_transport")
    private Transport transport;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_accommodation")
    private Accommodation accommodation;

    @ManyToOne
    @JoinColumn(name = "id_departure")
    private Location departure_location;

    @Length(max = 255, message = "Try again! Name is too long")
    @NotEmpty(message = "Try again! Name cannot be empty")
    @Column(name = "name")
    private String name;

    @DateTimeFormat
    @Future
    @Column(name = "departure_date")
    private LocalDate departure_date;

    @DateTimeFormat
    @Future
    @Column(name = "arrival_date")
    private LocalDate arrival_date;

    @Positive
    @Column(name = "budget")
    private int budget;

    @Positive
    @Column(name = "persons")
    private int persons;

    @ManyToMany
    @JoinTable(
            name = "itinerary_attraction",
            joinColumns = @JoinColumn(name = "id_itinerary"),
            inverseJoinColumns = @JoinColumn(name = "id_attraction")
    )
    private List<Attraction> attractions;
}
