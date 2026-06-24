package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    // 1. Get all countries (Exercise 4)
    @GetMapping
    public List<Country> getAllCountries() {
        return Arrays.asList(
            new Country("IN", "India", "New Delhi"),
            new Country("US", "United States", "Washington D.C."),
            new Country("UK", "United Kingdom", "London"),
            new Country("CA", "Canada", "Ottawa"),
            new Country("AU", "Australia", "Canberra")
        );
    }

    // 2. Get country by code (Exercise 5)
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        // Find the country that matches the code
        return getAllCountries().stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); // Returns null if not found
    }
}