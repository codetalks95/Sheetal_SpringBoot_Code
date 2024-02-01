package com.sheetal.sheetal_springboot_project.exceptionhandling;

public class AgeNotFoundException extends Exception{
    public AgeNotFoundException(String message) {
        super(message);
    }
}
