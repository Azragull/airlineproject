package com.airline.controller;

import com.airline.model.User;
import com.airline.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Bu e-posta ile kullanıcı zaten var!");
        }
        userRepository.save(user);
        return ResponseEntity.ok("Kayıt başarılı!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        Optional<User> userOpt = userRepository.findByEmail(loginUser.getEmail());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(loginUser.getPassword())) {
            User user = userOpt.get();
            user.setPassword(""); // Şifreyi dönme
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(401).body("Geçersiz e-posta veya şifre!");
    }
} 