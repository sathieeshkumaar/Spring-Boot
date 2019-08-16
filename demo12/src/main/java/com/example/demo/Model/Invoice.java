package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
@Document
@Data
public class Invoice {
    @Id
    private String id;

    @Size(min = 2,message = "Atleast 2 characters")
    private String firstname;

    @Size(min = 2,message = "Atleast 2 characters")
    private String contact_number;

    @Size(min = 30,message = "Atleast 30 characters")
    private String address;

    @Size(min = 4, max = 11, message="Enter mode of payment")
    private String zip;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String cvv;

    @Size(min = 3,message = "Invalid email")
    private String email;

}
