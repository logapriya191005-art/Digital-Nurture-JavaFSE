package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
    
    private final MessageSender messageSender;

    // Spring automatically injects the MessageSender dependency here!
    @Autowired
    public MessageProcessor(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void process(String text) {
        System.out.println("Processing message...");
        messageSender.send(text);
    }
}