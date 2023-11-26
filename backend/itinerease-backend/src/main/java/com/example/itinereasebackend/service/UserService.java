package com.example.itinereasebackend.service;

import com.example.itinereasebackend.api.model.User;
import com.example.itinereasebackend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
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
        _userRepository.save(user);

    }
    public List<User> getAll(){
        return _userRepository.findAll();
    }

    public Optional<User> getById(int userId) {
        return _userRepository.findById(userId);
    }

    public void update(int userId, User updatedUser) {
        Optional<User> existingUser = _userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setFirst_name(updatedUser.getFirst_name());
            userToUpdate.setLast_name(updatedUser.getLast_name());
            userToUpdate.setPhone_number(updatedUser.getPhone_number());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());
            _userRepository.save(userToUpdate);
        } else {
            // TODO Trebuie sa tratam cazul in care nu exista
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public void delete(int userId) {
        // TODO trebuie sa tratam si cazul in care nu exista userul pe care vrem sa il stergem
        _userRepository.deleteById(userId);
    }
}
