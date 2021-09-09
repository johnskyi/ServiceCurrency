package com.example.ServiceCurrency.repo;

import com.example.ServiceCurrency.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends MongoRepository<Course,String> {
}
