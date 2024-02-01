package com.sheetal.sheetal_springboot_project.exceptionhandling;

import com.sheetal.sheetal_springboot_project.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setException("Runtime Exception Occurred");
        exceptionResponse.setStatusCode("500");
        exceptionResponse.setMessage("Runtime Exception has Occurred");
        exceptionResponse.setDateTimeFormat(new Date());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AgeNotFoundException.class)
    public ResponseEntity<Object> handleAgeException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setException("Age is less then 18 Years");
        exceptionResponse.setStatusCode("500");
        exceptionResponse.setMessage("Not Eligible for Vote");
        exceptionResponse.setDateTimeFormat(new Date());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(LoginCustomException.class)
    public ResponseEntity<Object> handleLoginException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setException("Credentials are not Correct");
        exceptionResponse.setStatusCode("500");
        exceptionResponse.setMessage("Please Re-Verify the Credentials");
        exceptionResponse.setDateTimeFormat(new Date());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
