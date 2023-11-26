package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.User;
import com.example.itinereasebackend.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PutMapping("/user")
    public void update(@RequestBody User user) {
        userService.update(user.getEmail(), user);
    }

    @DeleteMapping("/user/{email}")
    public void delete(@PathVariable String email) {
        userService.delete(email);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Object> getUserByCredentials(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        try {
            User user = userService.getUserByCredentials(email, password);
            return ResponseEntity.ok(user);
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
