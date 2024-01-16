package com.sheetal.sheetal_springboot_project.response;

import com.sheetal.sheetal_springboot_project.entity.MilkRateClass;
import com.sheetal.sheetal_springboot_project.entity.RateClass;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
