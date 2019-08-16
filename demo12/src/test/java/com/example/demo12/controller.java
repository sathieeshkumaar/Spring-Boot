package com.example.demo12;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
public class controller {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello")));

    }
}
