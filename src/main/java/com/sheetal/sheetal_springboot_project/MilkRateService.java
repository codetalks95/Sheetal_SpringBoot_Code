package com.sheetal.sheetal_springboot_project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MilkRateService {

    @Value("${milkRate}")
    private int milkRate;

    public int milkRateService() {
        return milkRate;
    }
}
