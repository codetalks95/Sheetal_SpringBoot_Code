package com.sheetal.sheetal_springboot_project.service;

import com.sheetal.sheetal_springboot_project.entity.LoginCredentials;
import com.sheetal.sheetal_springboot_project.exceptionhandling.LoginCustomException;
import com.sheetal.sheetal_springboot_project.repository.LoginCredentialsRepository;
import com.sheetal.sheetal_springboot_project.response.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.sheetal.sheetal_springboot_project.constants.Constants.*;

@Service
public class LoginService {

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    BCryptPasswordEncoder bCryptPasswordEncoder;
    LoginCredentialsRepository loginCredentialsRepository;

    @Autowired
    public LoginService(BCryptPasswordEncoder bCryptPasswordEncoder, LoginCredentialsRepository loginCredentialsRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loginCredentialsRepository = loginCredentialsRepository;
    }

    public LoginResponse saveCredentials(LoginCredentials loginCredentials) {
        LoginCredentials loginCredentialsValue = new LoginCredentials();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(DATA_SAVED);
        loginCredentialsValue.setUserName(bCryptPasswordEncoder.encode(loginCredentials.getUserName()));
        loginCredentialsValue.setPassword(bCryptPasswordEncoder.encode(loginCredentials.getPassword()));
        loginCredentialsRepository.save(loginCredentialsValue);
        logger.info("Login Credentials Value is:{}", loginCredentialsValue);
        loginResponse.setStatus(HttpStatus.OK);
        loginResponse.setMessage(DATA_SAVED);
        Optional<LoginCredentials> loginCredentials1 = loginCredentialsRepository.findTopByOrderByIdDesc();
        loginCredentials1.ifPresent(loginResponse::setLoginCredentials);
        return loginResponse;
    }

    public LoginResponse getLoginCredentials() {
        LoginResponse loginResponse = new LoginResponse();
        Optional<LoginCredentials> loginCredentials = loginCredentialsRepository.findTopByOrderByIdDesc();
        if (loginCredentials.isPresent()) {
            loginResponse.setStatus(HttpStatus.OK);
            loginResponse.setMessage(DATA_FETCHED);
            loginResponse.setLoginCredentials(loginCredentials.get());
            logger.debug("Login Credentials Value is:{}", loginCredentials.get());
        } else {
            logger.error("The Id is not Present");
        }
        return loginResponse;
    }

    public LoginResponse verifyCredentials(LoginCredentials loginCredentials) throws LoginCustomException {
        Optional<LoginCredentials> loginCredentials1 = loginCredentialsRepository.findTopByOrderByIdDesc();
        LoginResponse loginResponse = new LoginResponse();
        if (loginCredentials1.isPresent() && bCryptPasswordEncoder.matches(loginCredentials.getUserName(), loginCredentials1.get().getUserName()) && bCryptPasswordEncoder.matches(loginCredentials.getPassword(), loginCredentials1.get().getPassword())) {
            loginResponse.setStatus(HttpStatus.OK);
            loginResponse.setMessage(CREDENTIALS_VERIFIED_MESSAGE);
            loginResponse.setLoginCredentials(loginCredentials1.get());
        } else {
            throw new LoginCustomException(LOGIN_NOT_FOUND);
//            loginResponse.setStatus(HttpStatus.NOT_FOUND);
//            loginResponse.setMessage(CREDENTIALS_INCORRECT_MESSAGE);
//            loginCredentials1.ifPresent(loginResponse::setLoginCredentials);
        }
        logger.warn("Your Credentials are sensitive , please don't use it in production.");
        return loginResponse;
    }
}
