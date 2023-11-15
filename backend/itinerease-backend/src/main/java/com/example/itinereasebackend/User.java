package com.example.itinereasebackend;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class User{
    @Id
    @Column(name = "id")
    private int id;
    @NotBlank
    @Column(name = "lastName")
    private String lastName;
    @NotBlank
    @Column(name = "firstName")
    private String firstName;
    @NotBlank
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @NotBlank
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "password")
    private String password;

}
