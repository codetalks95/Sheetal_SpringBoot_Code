package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/milkRateGetMapping")
    public Model getMilkRate() {
        return rateService.milkRateService();
    }

    @PostMapping("/milkRatePostMapping/{milkRate}")
    public Model saveMilkRatePostMapping(@PathVariable int milkRate) {
        return rateService.saveMilkRate(milkRate);
    }

    @PutMapping("/milkRatePutMapping/{milkRate}/{id}")
    public Model saveMilkRatePutMapping(@PathVariable int milkRate ,@PathVariable int id) {
        return rateService.putMappingSave(milkRate,id);
    }

    @PatchMapping("/milkRatePatchMapping/{id}")
    public RateClass patchPartialDataMapping(@PathVariable int id , @RequestBody Map<String, Object> map) {
        return rateService.patchMilkRate(id , map);
    }

    @DeleteMapping("/milkRateDeleteMapping/{id}")
    public Model deleteMilkRateMapping(@PathVariable int id) {
        return rateService.deleteMilkRate(id);
    }
}
