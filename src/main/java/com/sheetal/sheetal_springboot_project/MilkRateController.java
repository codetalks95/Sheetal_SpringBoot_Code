package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MilkRateController {

    @Autowired
    private MilkRateService milkRateService;

    //Constructor Injection
//    private MilkRateService milkRateService;
//    @Autowired
//    public MilkRateController(MilkRateService milkRateService) {
//        this.milkRateService = milkRateService;
//    }


    //Setter Injection
    //private MilkRateService milkRateService;
//    @Autowired
//    public void setMilkRateService(MilkRateService milkRateService) {
//        this.milkRateService = milkRateService;
//    }

    @GetMapping("/getMilkRate")
    public Model getMilkRate() {
        return milkRateService.milkRateService();
    }
}
