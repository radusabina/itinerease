package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.User;
import com.example.itinereasebackend.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
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
        userService.update(user.getId(), user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
