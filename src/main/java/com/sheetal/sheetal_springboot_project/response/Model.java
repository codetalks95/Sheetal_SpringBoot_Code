package com.sheetal.sheetal_springboot_project.response;

import com.sheetal.sheetal_springboot_project.entity.MilkRateClass;
import com.sheetal.sheetal_springboot_project.entity.RateClass;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@XmlRootElement
@Data
public class Model {
    private int status;
    private String message;
    private RateClass rateClass;
    private MilkRateClass milkRateClass;
    private List<MilkRateClass> milkRateClassList;
}
