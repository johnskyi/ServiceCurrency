package com.example.ServiceCurrency.service;

import com.example.ServiceCurrency.repo.CourseRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public void updateCourse(){}
    public void compareCourse(){}
    public void getGif(){}

}
