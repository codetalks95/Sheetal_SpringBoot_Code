package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;
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

        Optional<MilkRateClass> id = milkRateRepository.findTopByOrderByIdDesc();
        if (id.isPresent()) {
            Optional<MilkRateClass> rateClass1 = milkRateRepository.findById(id.get().getId());
            if (rateClass1.isPresent()) {
                rateClass.setMilkRate(rateClass1.get().getMilkRate());
                rateClass.setKhowaRate(rateClass1.get().getMilkRate() * 2);
                rateClass.setPaneerRate(Math.round(rateClass1.get().getMilkRate() * 8 / 3));
                rateClass.setDate(String.valueOf(new Date()));
            }
            model.setMilkRateClass(rateClass1.get());
            model.setMessage("The Data has been successfully fetched");
        } else {
            model.setMessage("Id is not found in the Database");
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

    public Model putMappingSave(int milkRate, int id) {
        Model model = new Model();
        Optional<MilkRateClass> milkRateClass = milkRateRepository.findById(id);
        if (milkRateClass.isPresent()) {
            milkRateClass.get().setMilkRate(milkRate);
            milkRateClass.get().setDate(String.valueOf(new Date()));
            milkRateRepository.save(milkRateClass.get());
            model.setMilkRateClass(milkRateClass.get());
            model.setMessage("Data has been updated successfully");
            model.setStatus(200);
        } else {
            model.setMessage("Id doesn't exist,Please give a retry with correct Id");
            model.setStatus(400);
        }
        return model;
    }

    public Model deleteMilkRate(int id) {
        Model model = new Model();
        Optional<MilkRateClass> milkRateClass = milkRateRepository.findById(id);
        if (milkRateClass.isEmpty()) {
            model.setMessage("Id has not been found");
            model.setStatus(500);
        } else {
            milkRateRepository.deleteById(milkRateClass.get().getId());
            model.setMessage("Id has been deleted successfully");
            model.setStatus(200);
        }
        return model;
    }

    public RateClass patchMilkRate(int id, Map<String, Object> map) {
        Optional<RateClass> rateClass = rateRepository.findById(id);
        if (rateClass.isPresent()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Field field = ReflectionUtils.findField(RateClass.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, rateClass.get(), value);
            }
            return rateRepository.save(rateClass.get());
        }
        return null;
    }
}
