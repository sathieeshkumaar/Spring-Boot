package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class PostPaidData {
    @Id
    private String id;

    private String user;
    private PostPaid postpaid;
    private Payment payment;


}
