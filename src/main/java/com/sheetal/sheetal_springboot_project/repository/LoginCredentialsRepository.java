package com.sheetal.sheetal_springboot_project.repository;

import com.sheetal.sheetal_springboot_project.entity.LoginCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials, Integer> {

    Optional<LoginCredentials> findTopByOrderByIdDesc();
}
