package com.sheetal.sheetal_springboot_project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "login_credentials")
@Entity
public class LoginCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
}
