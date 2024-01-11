package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MilkRateController {

    @Autowired
    private MilkRateService milkRateService;

    @GetMapping("/getMilkRate")
    public int getMilkRate() {
        return milkRateService.milkRateService();
    }
}
