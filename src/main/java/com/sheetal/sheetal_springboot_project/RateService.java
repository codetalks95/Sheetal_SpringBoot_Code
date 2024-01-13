package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RateService {

    RateRepository rateRepository;
    MilkRateRepository milkRateRepository;

    @Autowired
    public RateService(RateRepository rateRepository, MilkRateRepository milkRateRepository) {
        this.rateRepository = rateRepository;
        this.milkRateRepository = milkRateRepository;
    }

    @Value("${milkRate}")
    private int milkRate;

    public Model milkRateService() {
        RateClass rateClass = new RateClass();
        Model model = new Model();
        model.setMessage("Milk Rate has been successfully fetched");
        Optional<MilkRateClass> id = milkRateRepository.findTopByOrderByIdDesc();
        if (id.isPresent()) {
            Optional<MilkRateClass> rateClass1 = milkRateRepository.findById(id.get().getId());
            if (rateClass1.isPresent()) {
                rateClass.setMilkRate(rateClass1.get().getMilkRate());
                rateClass.setKhowaRate(rateClass1.get().getMilkRate() * 2);
                rateClass.setPaneerRate(Math.round(rateClass1.get().getMilkRate() * 8 / 3));
                rateClass.setDate(String.valueOf(new Date()));
            }
        }
        rateRepository.save(rateClass);
        model.setStatus(200);
        model.setRateClass(rateClass);
        return model;
    }

    public Model saveMilkRate(int milkRate) {
        MilkRateClass milkRateClass = new MilkRateClass();
        Model model = new Model();
        model.setMessage("Milk Rate has been successfully fetched");
        milkRateClass.setMilkRate(milkRate);
        milkRateClass.setDate(String.valueOf(new Date()));
        milkRateRepository.save(milkRateClass);
        model.setStatus(200);
        model.setRateClass(null);
        model.setMilkRateClass(milkRateClass);
        return model;
    }
}
