package com.sheetal.sheetal_springboot_project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "milkRate")
public class MilkRateClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double milkRate;
    private String date;

    public double getMilkRate() {
        return milkRate;
    }

    public void setMilkRate(double milkRate) {
        this.milkRate = milkRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
