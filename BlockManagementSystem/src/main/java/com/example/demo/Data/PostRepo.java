package com.example.demo.Data;

import com.example.demo.Model.Create;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface PostRepo extends MongoRepository<Create,String> {
    List<Create> findByName(String name);
    List<Create> findBy_id(String _id);
    Create findAllBy_id(String _id);
    void deleteBy_id(String _id);
}
