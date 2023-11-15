package com.example.itinereasebackend;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.itinereasebackend")
public class ItinereaseBackendApplication implements CommandLineRunner {

	private final UserService userService;

	public ItinereaseBackendApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ItinereaseBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(1,"Topi","Alex","0747320869",
				"topi@gmail.com","topi");
		userService.createUser(user);
	}
}