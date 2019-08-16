package com.example.demo.Data;

import com.example.demo.Model.PostPaidData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostPaidDataRepo extends MongoRepository<PostPaidData,String> {
    List<PostPaidData> getByUser(String s);
}
