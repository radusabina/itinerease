package com.example.itinereasebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserService {

    private final @Autowired UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }
    @GetMapping("/users")
    public Iterable<User> findAllUsers() {
        return this._userRepository.findAll();
    }

    @PostMapping("/users")
    public User addOneUser(@RequestBody User user) {
        return this._userRepository.save(user);
    }

    public Optional<User> getUserById(int userId) {
        return _userRepository.findById(userId);
    }

    public void createUser(User user) {
        // validari in cazul in care este necesar
        _userRepository.save(user);
    }

    public void updateUser(int userId, User updatedUser) {
        Optional<User> existingUser = _userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setFirstName(updatedUser.getFirstName());
            userToUpdate.setLastName(updatedUser.getLastName());
            userToUpdate.setPhoneNumber(updatedUser.getPhoneNumber());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());
            _userRepository.save(userToUpdate);
        } else {
            // Trebuie sa tratam cazul in care nu exista
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public void deleteUser(int userId) {
        // trebuie sa tratam si cazul in care nu exista userul pe care vrem sa il stergem
        _userRepository.deleteById(userId);
    }
}
