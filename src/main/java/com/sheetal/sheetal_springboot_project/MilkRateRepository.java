package com.sheetal.sheetal_springboot_project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MilkRateRepository extends JpaRepository<MilkRateClass, Integer> {
    Optional<MilkRateClass> findTopByOrderByIdDesc();
}
