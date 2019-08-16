package com.example.demo.Data;

import com.example.demo.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public class SearchRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    public Collection searchCars(String text) {
        return mongoTemplate.find(Query.query(new Criteria()
                .orOperator(Criteria.where("user").regex(text, "i"),
                        Criteria.where("payment").regex(text, "i"),
                        Criteria.where("postpaid").regex(text, "i"),
                        Criteria.where("prepaidPlans").regex(text, "i"),
                        Criteria.where("dongle").regex(text, "i"))
        ), Order.class);
    }

}
