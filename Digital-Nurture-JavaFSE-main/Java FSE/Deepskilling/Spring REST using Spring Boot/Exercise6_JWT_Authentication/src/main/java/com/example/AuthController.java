package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final JwtService jwtService = new JwtService();
    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        
        // Simple validation (in real app, check against database)
        if (username != null && !username.isEmpty() && 
            password != null && !password.isEmpty()) {
            
            String token = jwtService.generateToken(username);
            
            return Map.of(
                "token", token,
                "message", "Authentication successful"
            );
        }
        
        return Map.of("error", "Invalid credentials");
    }
    
    @GetMapping("/verify")
    public Map<String, String> verifyToken(@RequestParam String token) {
        // In a real app, you would verify the token here
        if (token != null && !token.isEmpty()) {
            return Map.of("valid", "true", "message", "Token is valid");
        }
        return Map.of("valid", "false", "message", "Invalid token");
    }
}