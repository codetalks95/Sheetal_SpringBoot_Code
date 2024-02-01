package com.sheetal.sheetal_springboot_project.controller;

import com.sheetal.sheetal_springboot_project.exceptionhandling.AgeNotFoundException;
import com.sheetal.sheetal_springboot_project.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    ExceptionService exceptionService;

    @Autowired
    public ExceptionController(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @GetMapping(value = "/handleExceptionCode/{age}")
    public boolean handleExceptions(@PathVariable int age) throws AgeNotFoundException {
        return exceptionService.eligibleForVote(age);
    }
}
