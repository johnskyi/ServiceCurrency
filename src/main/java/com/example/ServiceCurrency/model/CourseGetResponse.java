package com.example.ServiceCurrency.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class CourseGetResponse {

    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private HashMap<String,Double> rates;
}
