package com.example.demo.Data;

import com.example.demo.Model.Dongle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DongleRepo extends MongoRepository<Dongle,String> {
    List<Dongle> getByName(String name);
}
