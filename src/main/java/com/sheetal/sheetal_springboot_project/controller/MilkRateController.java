package com.sheetal.sheetal_springboot_project.controller;

import com.sheetal.sheetal_springboot_project.response.Model;
import com.sheetal.sheetal_springboot_project.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MilkRateController {

    private final RateService rateService;

    @Autowired
    public MilkRateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping(value = "/getMappingForMilkRate", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public Model getMappingForMilkRate() {
        return rateService.getMilkRateData();
    }

    @PostMapping("/postMappingForMilkRate/{milkRate}")
    public Model postMappingForMilkRate(@PathVariable int milkRate) {
        return rateService.saveDataForMilkRate(milkRate);
    }

    @PutMapping("/putMappingForMilkRate/{milkRate}/{id}")
    public Model putMappingForMilkRate(@PathVariable int milkRate , @PathVariable int id) {
        return rateService.updateDataForMilkRate(milkRate,id);
    }

    @PatchMapping("/patchMappingForMilkRate/{id}")
    public Model patchMappingForMilkRate(@PathVariable int id , @RequestBody Map<String, Object> map) {
        return rateService.partialUpdateDataForMilkRate(id , map);
    }

    @DeleteMapping("/deleteMappingForMilkRate/{id}")
    public Model deleteMappingForMilkRate(@PathVariable int id) {
        return rateService.deleteDataFromMilkRate(id);
    }
}
