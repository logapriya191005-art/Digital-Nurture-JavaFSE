package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Get the Country bean from Spring container
        Country country = (Country) context.getBean("country");
        
        // Display the country information
        System.out.println("Country loaded from XML configuration:");
        System.out.println(country);
    }
}