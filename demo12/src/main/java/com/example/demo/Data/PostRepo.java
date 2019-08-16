package com.example.demo.Data;

import com.example.demo.Model.Dongle;
import com.example.demo.Model.PostPaid;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepo extends MongoRepository<PostPaid,String> {
    List<PostPaid> getByName(String name);
}
