package com.sheetal.sheetal_springboot_project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "milkRate")
@Data
public class MilkRateClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double milkRate;
    private String date;
}
