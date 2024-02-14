package com.sheetal.sheetal_springboot_project.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExceptionResponse implements Serializable {
    private String message;
    private String statusCode;
    private String exception;
    private Date dateTimeFormat;
}
