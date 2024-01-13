package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MilkRateController {

    private RateService rateService;

    @Autowired
    public MilkRateController(RateService rateService) {
        this.rateService = rateService;
    }


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
        return rateService.milkRateService();
    }

    @PostMapping("/saveMilkRate/{milkRate}")
    public Model getMilkRate(@PathVariable int milkRate) {
        return rateService.saveMilkRate(milkRate);
    }
}
