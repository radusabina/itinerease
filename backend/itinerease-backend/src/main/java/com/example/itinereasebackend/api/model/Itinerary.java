package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_destination", referencedColumnName = "id")
    private Location destination_location;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_transport")
    private Transport transport;

    @ManyToOne(cascade = CascadeType.MERGE)
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


    @Override
    public String toString() {
        return '{' +
                "id=" + id +
                ", destination_location=" + destination_location +
                ", transport=" + transport +
                ", user=" + user +
                ", accommodation=" + accommodation +
                ", departure_location=" + departure_location +
                ", name='" + name + '\'' +
                ", departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                ", budget=" + budget +
                ", persons=" + persons +
                ", attractions=" + attractions +
                '}';}

    public Itinerary(Location destinationLocation, Transport transport, User user, Accommodation accommodation,
                     Location departureLocation, String name, LocalDate departureDate, LocalDate arrivalDate,
                     int budget, int persons) {
        this.destination_location = destinationLocation;
        this.transport = transport;
        this.user = user;
        this.accommodation = accommodation;
        this.departure_location = departureLocation;
        this.name = name;
        this.departure_date = departureDate;
        this.arrival_date = arrivalDate;
        this.budget = budget;
        this.persons = persons;
    }


}
