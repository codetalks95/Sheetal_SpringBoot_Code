package com.sheetal.sheetal_springboot_project.response;

import com.sheetal.sheetal_springboot_project.entity.LoginCredentials;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class LoginResponse {
    private HttpStatus status;
    private String message;
    private LoginCredentials loginCredentials;
}
