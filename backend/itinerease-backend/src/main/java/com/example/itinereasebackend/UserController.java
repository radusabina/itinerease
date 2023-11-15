package com.example.itinereasebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/addUser")
    public void create(@RequestBody User user) {
        this.userRepository.save(user);
    }
}
