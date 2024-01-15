package com.sheetal.sheetal_springboot_project.repository;

import com.sheetal.sheetal_springboot_project.entity.MilkRateClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MilkRateRepository extends JpaRepository<MilkRateClass, Integer> {
    Optional<MilkRateClass> findTopByOrderByIdDesc();
}
