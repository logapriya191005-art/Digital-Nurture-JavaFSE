package com.example.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{id}")
    public Map<String, Object> getLoan(@PathVariable String id) {
        return Map.of(
            "loanId", id,
            "loanType", "Home Loan",
            "amount", 250000.00,
            "interestRate", 8.5,
            "status", "Approved"
        );
    }
}