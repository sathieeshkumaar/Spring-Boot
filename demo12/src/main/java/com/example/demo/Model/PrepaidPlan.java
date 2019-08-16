package com.example.demo.Model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor

public class PrepaidPlan
{
    @Id
    private String Id;

    private final String name;
    private final String valid;
    private final String amount;


}
