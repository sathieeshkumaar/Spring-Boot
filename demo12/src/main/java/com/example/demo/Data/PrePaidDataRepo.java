package com.example.demo.Data;

import com.example.demo.Model.Order;
import com.example.demo.Model.PrePaidData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrePaidDataRepo extends MongoRepository<PrePaidData,String> {
    List<PrePaidData> getByUser(String s);
}
