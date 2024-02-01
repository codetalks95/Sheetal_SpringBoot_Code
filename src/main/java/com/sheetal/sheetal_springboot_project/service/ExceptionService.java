package com.sheetal.sheetal_springboot_project.service;

import com.sheetal.sheetal_springboot_project.exceptionhandling.AgeNotFoundException;
import org.springframework.stereotype.Service;

import static com.sheetal.sheetal_springboot_project.constants.Constants.AGE_NOT_FOUND_EXCEPTION;

@Service
public class ExceptionService {

    public boolean eligibleForVote(int myAge) throws AgeNotFoundException {
        if (myAge > 18) {
            return true;
        } else {
            throw new AgeNotFoundException(AGE_NOT_FOUND_EXCEPTION);
        }
    }
}
