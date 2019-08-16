package com.example.demo.Controller;

import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/assistance")
@SessionAttributes("register")
public class AssistanceController {
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public AssistanceController(UserCredentialsRepository userCredentialsRepository)
    {
        this.userCredentialsRepository=userCredentialsRepository;
    }
    @GetMapping
    public String print(Model model, @ModelAttribute Register register)
    {
        List<Register1> user = userCredentialsRepository.findByName(register.getName());
        model.addAttribute("user", user);
        return "assistance";
    }
}
