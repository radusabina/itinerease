package com.example.itinereasebackend.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user", schema = "public")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Length(max = 255, message = "Try again! Last name is too long")
    @NotEmpty(message = "Try again! Last name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Try again! Last name must start with an uppercase letter")
    @Column(name = "last_name")
    private String last_name;

    @Length(max = 255, message = "Try again! First name is too long")
    @NotEmpty(message = "Try again! First name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Try again! First name must start with an uppercase letter")
    @Column(name = "first_name")
    private String first_name;

    @Length(max = 10, message = "Try again! Phone number is too long")
    @NotEmpty(message = "Try again! Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]+$", message = "Try again! Only digits are allowed")
    @Column(name = "phone_number")
    private String phone_number;

    @Pattern(regexp = "^[a-zA-Z0-9@]+$", message = "Try again! Only letters, digits, and '@' are allowed")
    @Column(name = "email", unique = true)
    private String email;

    @Length(max = 255, message = "Try again! Password is too long")
    @NotEmpty(message = "Try again! Password cannot be empty")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$", message = "Try again! Password must meet the requirements.")
    @Column(name = "password")
    private String password;
}
