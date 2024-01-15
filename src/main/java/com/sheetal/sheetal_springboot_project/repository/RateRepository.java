package com.sheetal.sheetal_springboot_project.repository;

import com.sheetal.sheetal_springboot_project.entity.RateClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<RateClass, Integer> {
}
