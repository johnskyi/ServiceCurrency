package com.example.ServiceCurrency.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@Document
public class Course {
    @Id
    private ObjectId id;
    @Indexed
    private String name;

    private HashMap<String,Double> value;
}
