package com.airline.controller;

import com.airline.model.User;
import com.airline.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword("")); // Şifreleri gizle
        return users;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
} 