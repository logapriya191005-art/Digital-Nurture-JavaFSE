package com.example.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/{id}")
    public Map<String, Object> getAccount(@PathVariable String id) {
        return Map.of(
            "accountId", id,
            "accountType", "Savings",
            "balance", 5000.00,
            "status", "Active"
        );
    }
}