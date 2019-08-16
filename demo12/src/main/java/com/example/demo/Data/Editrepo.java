package com.example.demo.Data;

import com.example.demo.Model.Editprofile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Editrepo extends MongoRepository<Editprofile,String> {
}
