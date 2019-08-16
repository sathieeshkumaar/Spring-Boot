package com.example.demo.Data;

import com.example.demo.Model.DongleData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DongleDataRepo extends MongoRepository<DongleData,String> {
    List<DongleData> getByUser(String s);
}
