package com.example.demo.Data;

import com.example.demo.Model.Register1;
import com.example.demo.Model.Registration;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Registrationrepo extends MongoRepository<Registration,String> {
    List<Registration> findByName(String name);
}
