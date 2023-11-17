package com.example.itinereasebackend.api.controller;

import com.example.itinereasebackend.api.model.User;
import com.example.itinereasebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
