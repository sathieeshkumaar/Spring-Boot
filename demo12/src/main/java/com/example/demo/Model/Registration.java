package com.example.demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Random;

@Data
@Document
public class Registration {
   /* Random random=new Random();

    private int rand=random.nextInt(99999999)+900000000;
*/private long rand=(long)(Math.random()*100000000+9872100000L);
    @Id
    private String id;

    @Size(min = 2,message = "Atleast 2 characters")
    private String name;


    @Size(min = 2,message = "Atleast 2 characters")
    private String firstname;


    @Size(min = 2,message = "Atleast 2 characters")
    private String lastname;



    @Size(min = 30,message = "Atleast 30 characters")
    private String address;


    @Size(min = 5,message = "Atleast 5 characters")
    private String city;

    @Size(min = 5,message = "Atleast 5 characters")
    private String state;

    @Digits(integer=6, fraction=0, message="Invalid PIN Code")
    private String zip;

    @Digits(integer=12, fraction=0, message="Invalid aadhar number")
    private String aadhar;


    @Size(min = 3,message = "Invalid email")
    private String email;

    @NotBlank(message = "Invalid type")
    private String type;


}
