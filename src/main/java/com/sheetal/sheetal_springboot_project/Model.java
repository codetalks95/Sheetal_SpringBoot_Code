package com.sheetal.sheetal_springboot_project;

public class Model {
    private int status;
    private String message;
    private RateClass rateClass;
    private MilkRateClass milkRateClass;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RateClass getRateClass() {
        return rateClass;
    }

    public void setRateClass(RateClass rateClass) {
        this.rateClass = rateClass;
    }

    public MilkRateClass getMilkRateClass() {
        return milkRateClass;
    }

    public void setMilkRateClass(MilkRateClass milkRateClass) {
        this.milkRateClass = milkRateClass;
    }
}
