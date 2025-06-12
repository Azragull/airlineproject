package com.airline.config;

import com.airline.model.User;
import com.airline.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            // Test admin kullanıcısı oluştur
            if (!userRepository.findByEmail("admin@test.com").isPresent()) {
                User admin = new User();
                admin.setName("Admin User");
                admin.setEmail("admin@test.com");
                admin.setPassword("admin123");
                admin.setRole("admin");
                userRepository.save(admin);
                System.out.println("Test admin kullanıcısı oluşturuldu!");
            }
        };
    }
} 