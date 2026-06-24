package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaQuickExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaQuickExampleApplication.class, args);
    }

    // This runs automatically when the application starts
    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return (args) -> {
            // 1. Save a few students to the database
            repository.save(new Student("Alice", "alice@example.com"));
            repository.save(new Student("Bob", "bob@example.com"));
            repository.save(new Student("Charlie", "charlie@example.com"));

            // 2. Fetch all students from the database
            System.out.println("\n--- Students found with findAll(): ---");
            for (Student student : repository.findAll()) {
                System.out.println(student);
            }
        };
    }
}