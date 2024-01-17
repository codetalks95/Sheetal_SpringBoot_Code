package com.sheetal.sheetal_springboot_project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "milkRate")
@Data
public class MilkRateClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double milkRate;
    private String date;
}
