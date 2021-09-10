package com.example.ServiceCurrency.controller;


import com.example.ServiceCurrency.model.CourseGetResponse;
import com.example.ServiceCurrency.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CourseController {

    // CONFIGURATION VARIABLES
    @Value("${courses.appId}")
    private String appId;
    @Value("${courses.base}")
    private String base;
    @Value("${courses.symbols}")
    private String symbols;

    @Autowired
    CourseService courseService;

//    @Autowired
//    GifService gifService;

    // COMPARISON OF EXCHANGE RATES

    @GetMapping("/{date}.json")
    public CourseGetResponse course(@PathVariable("date") String date,
                                    @RequestParam("app_id") String appId,
                                    @RequestParam("base") String base,
                                    @RequestParam("symbols") String symbol) {
        return courseService.getCourse(date, appId, base, symbol);
    }


    @RequestMapping("/")
    public void startService() {
        try {
            if (compareCourses()) {
                System.out.println("RICH");
            } else {
                System.out.println("BROKE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean compareCourses() throws Exception {
        LocalDate now = LocalDate.now();
        CourseGetResponse courseNow = course(now.toString(), appId, base, symbols);
        CourseGetResponse courseYesterday = course(now.minusDays(1).toString(), appId, base, symbols);
        return courseNow.getRates().get(symbols) > courseYesterday.getRates().get(symbols);
    }
}
