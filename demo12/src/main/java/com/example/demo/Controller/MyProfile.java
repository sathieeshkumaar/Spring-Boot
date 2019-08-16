package com.example.demo.Controller;



import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PrePaidDataRepo;
import com.example.demo.Data.Registrationrepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.PrePaidData;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import com.example.demo.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/myprofile")
@SessionAttributes("register")
public class MyProfile {
    private UserCredentialsRepository userCredentialRepository;
    private Registrationrepo registrationrepo;

    @Autowired
    private MyProfile(UserCredentialsRepository userCredentialRepository,Registrationrepo registrationrepo) {
        this.userCredentialRepository = userCredentialRepository;
        this.registrationrepo=registrationrepo;

    }
    @ModelAttribute(name = "register1")
    public Register1 register1() {
        return new Register1();
    }
    @GetMapping
    public String newProfile(@SessionAttribute("register") Register register, Model model){
        List<Register1> user = userCredentialRepository.findByName(register.getName());
        List<Registration> reg=registrationrepo.findByName(register.getName());
        model.addAttribute("user", user);
        model.addAttribute("reg", reg);

        return "myprofile";

    }
}
