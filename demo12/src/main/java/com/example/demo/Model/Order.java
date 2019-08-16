package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@Document
@Data
public class Order {
    @Id
    private String id;

   private String user;



    private Dongle dongle;
   private Payment payment;
   private PostPaid postPaid;
   private PrepaidPlan prepaidplan;


}
