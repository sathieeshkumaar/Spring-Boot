package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vftelecom")
public class IndexController {
    @GetMapping
    public String voizFoni()
    {
        return "index";
    }


}
