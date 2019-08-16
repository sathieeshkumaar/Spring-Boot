package com.example.demo.Data;

import com.example.demo.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepo extends MongoRepository<Order,String> {
    List<Order> getByUser(String s);
}
