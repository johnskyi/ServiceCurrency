package com.example.ServiceCurrency.controller;

import com.example.ServiceCurrency.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseService courseService;
}
