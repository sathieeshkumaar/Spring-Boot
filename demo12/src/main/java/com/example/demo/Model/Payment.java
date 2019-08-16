package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
@Data
@Document
public class Payment {
    @Id
    private String id;

    @Size(min = 3,message = "Enter a Valid Name")
    private String owner;


    @Size(min = 3,max = 3,message = "Enter a valid Cvv")
    private String cvv;



    @Size(min =16,max = 16,message = "Enter a valid Card Number")
    private String card;

    @Size(min =100,max = 1000,message = "Enter a valid Card Number")
    private String amount;

    @Size(min = 3,message = "Invalid email")
    private String exp;

    private String plan;

}
