package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RateService {

    RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Value("${milkRate}")
    private int milkRate;

    public Model milkRateService() {
        RateClass rateClass = new RateClass();
        Model model = new Model();
        model.setMessage("Milk Rate has been successfully fetched");
        rateClass.setMilkRate(milkRate);
        rateClass.setKhowaRate(milkRate * 2);
        rateClass.setPaneerRate(Math.round(milkRate * 8 / 3));
        rateClass.setDate(String.valueOf(new Date()));
        rateRepository.save(rateClass);
        model.setStatus(200);
        model.setRateClass(rateClass);
        return model;
    }
}
