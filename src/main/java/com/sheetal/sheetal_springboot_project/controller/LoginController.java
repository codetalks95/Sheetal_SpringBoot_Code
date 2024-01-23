package com.sheetal.sheetal_springboot_project.controller;

import com.sheetal.sheetal_springboot_project.entity.LoginCredentials;
import com.sheetal.sheetal_springboot_project.response.LoginResponse;
import com.sheetal.sheetal_springboot_project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/getLoginCredentials")
    public LoginResponse getLoginCredentials() {
        return loginService.getLoginCredentials();
    }

    @PostMapping("/saveLoginCredentials")
    public LoginResponse saveLoginCredentials(@RequestBody LoginCredentials loginCredentials) {
        return loginService.saveCredentials(loginCredentials);
    }

    @GetMapping(value = "/verifyCredentials")
    public LoginResponse verifyCredentials(@RequestBody LoginCredentials loginCredentials) {
        return loginService.verifyCredentials(loginCredentials);
    }
}
