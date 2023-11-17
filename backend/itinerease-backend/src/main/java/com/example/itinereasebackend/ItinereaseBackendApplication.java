package com.example.itinereasebackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.itinereasebackend")
public class ItinereaseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItinereaseBackendApplication.class, args);
	}

}