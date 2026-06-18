package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 1. Load the Spring Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // 2. Get the MessageProcessor bean (Spring automatically injects EmailSender into it!)
        MessageProcessor processor = context.getBean(MessageProcessor.class);
        
        // 3. Use it
        processor.process("Hello, Dependency Injection!");
    }
}