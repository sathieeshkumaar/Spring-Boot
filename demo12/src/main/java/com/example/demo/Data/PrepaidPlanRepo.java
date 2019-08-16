package com.example.demo.Data;


import com.example.demo.Model.PrepaidPlan;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrepaidPlanRepo extends MongoRepository<PrepaidPlan,String> {
    List<PrepaidPlan> getByName(String name);
}
