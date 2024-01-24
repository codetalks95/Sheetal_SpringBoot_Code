package com.sheetal.sheetal_springboot_project.service;


import com.sheetal.sheetal_springboot_project.constants.Constants;
import com.sheetal.sheetal_springboot_project.entity.MilkRateClass;
import com.sheetal.sheetal_springboot_project.entity.RateClass;
import com.sheetal.sheetal_springboot_project.repository.MilkRateRepository;
import com.sheetal.sheetal_springboot_project.repository.RateRepository;
import com.sheetal.sheetal_springboot_project.response.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.sheetal.sheetal_springboot_project.constants.Constants.*;

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

    public Model getMilkRateData() {
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
            rateClass1.ifPresent(model::setMilkRateClass);
            model.setMessage(DATA_FETCHED);
            model.setStatus(HttpStatus.OK);
            model.setRateClass(rateClass);
        } else {
            model.setMessage(DATA_NOT_FOUND);
            model.setStatus(HttpStatus.NOT_FOUND);
        }
        rateRepository.save(rateClass);

        return model;
    }

    public Model saveDataForMilkRate(int milkRate) {
        MilkRateClass milkRateClass = new MilkRateClass();
        Model model = new Model();
        model.setMessage(DATA_FETCHED);
        milkRateClass.setMilkRate(milkRate);
        milkRateClass.setDate(String.valueOf(new Date()));
        milkRateRepository.save(milkRateClass);
        model.setStatus(HttpStatus.OK);
        model.setMessage(DATA_SAVED);
        model.setMilkRateClass(milkRateClass);
        return model;
    }

    public Model updateDataForMilkRate(int milkRate, int id) {
        Model model = new Model();
        Optional<MilkRateClass> milkRateClass = milkRateRepository.findById(id);
        if (milkRateClass.isPresent()) {
            milkRateClass.get().setMilkRate(milkRate);
            milkRateClass.get().setDate(String.valueOf(new Date()));
            milkRateRepository.save(milkRateClass.get());
            model.setMilkRateClass(milkRateClass.get());
            model.setMessage(DATA_UPDATED);
            model.setStatus(HttpStatus.OK);
        } else {
            model.setMessage(DATA_NOT_FOUND);
            model.setStatus(HttpStatus.NOT_FOUND);
        }
        return model;
    }

    public Model deleteDataFromMilkRate(int id) {
        Model model = new Model();
        Optional<MilkRateClass> milkRateClass = milkRateRepository.findById(id);
        if (milkRateClass.isEmpty()) {
            model.setMessage(DATA_NOT_FOUND);
            model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            milkRateRepository.deleteById(milkRateClass.get().getId());
            model.setMessage(Constants.DATA_DELETED);
            model.setStatus(HttpStatus.OK);
        }
        return model;
    }

    public Model partialUpdateDataForMilkRate(int id, Map<String, Object> map) {
        Model model = new Model();
        Optional<RateClass> rateClassOptional = rateRepository.findById(id);
        if (rateClassOptional.isPresent()) {
            RateClass rateClass = rateClassOptional.get();
            updateFields(rateClass, map);
            model.setRateClass(rateClass);
            model.setMessage(Constants.DATA_UPDATED);
            model.setStatus(HttpStatus.OK);
        } else {
            model.setMessage(DATA_NOT_FOUND);
            model.setStatus(HttpStatus.NOT_FOUND);
        }
        return model;
    }

    private void updateFields(RateClass rateClass, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Field field = ReflectionUtils.findField(RateClass.class, key);

            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, rateClass, value);
            }
        }
    }

    public Model getMilkRateDataByMilkRate(double milkRate) {
        Model model = new Model();
        MilkRateClass milkRateClass = milkRateRepository.findByRateMilkRate(milkRate);
        return setStatusCodeAndResponse(model, milkRateClass);
    }

    private Model setStatusCodeAndResponse(Model model, MilkRateClass milkRateClass) {
        if (milkRateClass != null) {
            model.setMilkRateClass(milkRateClass);
            model.setMessage(DATA_FETCHED);
            model.setStatus(HttpStatus.OK);
        } else {
            model.setMessage(DATA_NOT_FOUND);
            model.setStatus(HttpStatus.NOT_FOUND);
        }
        return model;
    }

    public Model getMilkRateDataByOrder() {
        Model model = new Model();
        List<MilkRateClass> milkRateClass = milkRateRepository.getOrderOfMilkRate();
        if (milkRateClass != null) {
            model.setMilkRateClassList(milkRateClass);
            model.setMessage(DATA_FETCHED);
            model.setStatus(HttpStatus.OK);
        } else {
            model.setMessage(DATA_CANT_BE_PROCESSED);
            model.setStatus(HttpStatus.NOT_FOUND);
        }
        return model;
    }

    public Model getMilkRateDataByJPQL(double milkRate) {
        Model model = new Model();
        MilkRateClass milkRateClass = milkRateRepository.findByMilkRate(milkRate);
        return setStatusCodeAndResponse(model, milkRateClass);
    }
}