package com.sheetal.sheetal_springboot_project.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rate")
public class RateClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double milkRate;
    private double paneerRate;
    private double khowaRate;
    private String date;

    public double getMilkRate() {
        return milkRate;
    }

    public void setMilkRate(double milkRate) {
        this.milkRate = milkRate;
    }

    public double getPaneerRate() {
        return paneerRate;
    }

    public void setPaneerRate(double paneerRate) {
        this.paneerRate = paneerRate;
    }

    public double getKhowaRate() {
        return khowaRate;
    }

    public void setKhowaRate(double khowaRate) {
        this.khowaRate = khowaRate;
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
