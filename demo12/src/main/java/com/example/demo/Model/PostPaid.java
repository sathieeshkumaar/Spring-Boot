package com.example.demo.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor

public class PostPaid {
    @Id
    private String Id;

    private final String name;
    private final String valid;
    private final String amount;


}
