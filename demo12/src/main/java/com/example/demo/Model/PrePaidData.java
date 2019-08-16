package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class PrePaidData {
    @Id
    private String id;

    private String user;
    private PrepaidPlan prepaid;
    private Payment payment;


}
