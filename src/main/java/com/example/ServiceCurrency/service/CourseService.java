package com.example.ServiceCurrency.service;

import com.example.ServiceCurrency.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "course", url = "${courses.urlCourses}")
public interface CourseService {

//    https://openexchangerates.org/api/historical/2021-09-10.json?app_id=f6ef239b77134d4aa080327d45947e13&base=USD&symbols=EUR

    @GetMapping("/{date}.json")
    Course getCourse(@PathVariable("date") String date,
                     @RequestParam("app_id") String appId,
                     @RequestParam("base") String base,
                     @RequestParam("symbols") String symbol);
}
