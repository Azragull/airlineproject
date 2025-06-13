package com.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/health")
    public String healthCheck() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "Veritabanı bağlantısı başarılı";
        } catch (Exception e) {
            return "Veritabanı bağlantı hatası: " + e.getMessage();
        }
    }
} 