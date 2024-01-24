package com.sheetal.sheetal_springboot_project.repository;

import com.sheetal.sheetal_springboot_project.entity.MilkRateClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MilkRateRepository extends JpaRepository<MilkRateClass, Integer> {
    Optional<MilkRateClass> findTopByOrderByIdDesc();

    @Query(value = "select * from milk_rate where milk_rate=?1", nativeQuery = true)
    MilkRateClass findByRateMilkRate(double milkRate);

    @Query(value = "select * from milk_rate order by milk_rate", nativeQuery = true)
    List<MilkRateClass> getOrderOfMilkRate();

    MilkRateClass findByMilkRate(double milkRate);
}
