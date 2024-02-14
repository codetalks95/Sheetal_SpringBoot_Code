package com.sheetal.sheetal_springboot_project.controller;

import com.sheetal.sheetal_springboot_project.response.Model;
import com.sheetal.sheetal_springboot_project.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@EnableCaching
public class MilkRateController {

    private final RateService rateService;

    @Autowired
    public MilkRateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping(value = "/getMappingForMilkRateInXML", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public Model getMappingForMilkRateInXML() {
        return rateService.getMilkRateData();
    }

    @GetMapping(value = "/getMappingForMilkRateInJson")
    public Model getMappingForMilkRateInJson() {
        return rateService.getMilkRateData();
    }

    @PostMapping("/postMappingForMilkRate/{milkRate}")
    public Model postMappingForMilkRate(@PathVariable int milkRate) {
        return rateService.saveDataForMilkRate(milkRate);
    }

    @PutMapping("/putMappingForMilkRate/{milkRate}/{id}")
    public Model putMappingForMilkRate(@PathVariable int milkRate, @PathVariable int id) {
        return rateService.updateDataForMilkRate(milkRate, id);
    }

    @PatchMapping("/patchMappingForMilkRate/{id}")
    public Model patchMappingForMilkRate(@PathVariable int id, @RequestBody Map<String, Object> map) {
        return rateService.partialUpdateDataForMilkRate(id, map);
    }

    @DeleteMapping("/deleteMappingForMilkRate/{id}")
    public Model deleteMappingForMilkRate(@PathVariable int id) {
        return rateService.deleteDataFromMilkRate(id);
    }

    @GetMapping(value = "/getMappingForMilkRateByMilkRate/{milkRate}")
    @Cacheable(key = "#milkRate", value = "#MilkRateClass")
    public Model getMappingForMilkRateByMilkRate(@PathVariable double milkRate) {
        return rateService.getMilkRateDataByMilkRate(milkRate);
    }

    @GetMapping(value = "/getMappingForMilkRateByMilkRates/{milkRate}")
    @CacheEvict(key = "#milkRate", value = "#MilkRateClass")
    public String getMappingForMilkRateByMilkRateEvict(@PathVariable double milkRate) {
        return "Cache is Evicted!";
    }

    @GetMapping(value = "/getMilkRateDataByOrder")
    public Model getMilkRateDataByOrder() {
        return rateService.getMilkRateDataByOrder();
    }

    @GetMapping(value = "/getMilkRateDataByJPQL/{milkRate}")
    public Model getMilkRateDataByJPQL(@PathVariable double milkRate) {
        return rateService.getMilkRateDataByJPQL(milkRate);
    }
}
