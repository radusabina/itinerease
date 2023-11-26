package com.example.itinereasebackend.service;

import com.example.itinereasebackend.api.model.User;
import com.example.itinereasebackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository _userRepository;

    public void create(User user) {
        Optional<User> existingUser = _userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this email already exists.");
        } else {
            _userRepository.save(user);
        }
    }
    public List<User> getAll(){
        return _userRepository.findAll();
    }

    public Optional<User> getById(int userId) {
        return _userRepository.findById(userId);
    }

    public void update(String userEmail, User updatedUser) {
        Optional<User> existingUser = _userRepository.findByEmail(userEmail);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setFirst_name(updatedUser.getFirst_name());
            userToUpdate.setLast_name(updatedUser.getLast_name());
            userToUpdate.setPhone_number(updatedUser.getPhone_number());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());
            _userRepository.save(userToUpdate);
        } else {
            throw new RuntimeException("User not found with this email");
        }
    }

    public void delete(String userEmail) {
        Optional<User> existingUser = _userRepository.findByEmail(userEmail);
        if (existingUser.isPresent()) {
            _userRepository.deleteByEmail(userEmail);
        } else {
            throw new RuntimeException("User not found with this email");
        }
    }

}

