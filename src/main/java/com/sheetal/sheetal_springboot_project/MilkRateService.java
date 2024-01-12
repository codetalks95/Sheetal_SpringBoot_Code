package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MilkRateService {

    @Value("${milkRate}")
    private int milkRate;

    public Model milkRateService() {
        Model model = new Model();
        model.setMessage("Milk Rate has been successfully fetched");
        model.setStatus(200);
        model.setAmount(milkRate);
        return model;
    }
}
