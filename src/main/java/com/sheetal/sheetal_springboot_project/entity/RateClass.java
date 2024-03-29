package com.sheetal.sheetal_springboot_project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "rate")
@Data
public class RateClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double milkRate;
    private double paneerRate;
    private double khowaRate;
    private String date;
}
