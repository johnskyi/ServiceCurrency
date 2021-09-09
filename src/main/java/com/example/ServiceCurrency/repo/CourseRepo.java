package com.example.ServiceCurrency.repo;

import com.example.ServiceCurrency.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course,String> {
}
