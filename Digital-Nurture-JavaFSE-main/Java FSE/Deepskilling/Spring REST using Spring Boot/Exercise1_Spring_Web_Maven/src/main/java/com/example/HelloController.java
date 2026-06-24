package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    // This maps HTTP GET requests to /hello to this method
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring REST!";
    }
}