package com.sheetal.sheetal_springboot_project.response;

import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResponse {
    private String message;
    private String statusCode;
    private String exception;
    private Date dateTimeFormat;
}
