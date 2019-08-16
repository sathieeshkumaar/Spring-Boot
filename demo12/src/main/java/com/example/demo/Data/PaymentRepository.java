package com.example.demo.Data;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PaymentRepository extends MongoRepository<com.example.demo.Model.Payment,String> {
}
