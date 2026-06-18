package com.example;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}