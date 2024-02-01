package com.sheetal.sheetal_springboot_project.exceptionhandling;

public class LoginCustomException extends Exception{

    public LoginCustomException(String message) {
        super(message);
    }
}
