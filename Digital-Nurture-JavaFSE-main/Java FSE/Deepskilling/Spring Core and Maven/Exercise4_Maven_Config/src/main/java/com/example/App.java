package com.example;

import org.apache.commons.lang3.StringUtils;

public class App {
    public static void main(String[] args) {
        String text = "hello maven configuration exercise";
        
        System.out.println("Original text: " + text);
        System.out.println("Capitalized: " + StringUtils.capitalize(text));
        System.out.println("Reversed: " + StringUtils.reverse(text));
        System.out.println("Word count: " + StringUtils.countMatches(text, " "));
    }
}