package com.example.demo.Controller;

import com.example.demo.Data.Registrationrepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import com.example.demo.Model.Registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/registration")
@SessionAttributes("register")
public class RegstrationController {
    private Registrationrepo registrationrepo;
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    private JavaMailSender javaMail;
    @Autowired
    public RegstrationController(Registrationrepo registrationrepo,UserCredentialsRepository userCredentialsRepository)
    {
        this.registrationrepo = registrationrepo;
        this.userCredentialsRepository=userCredentialsRepository;
    }
    @ModelAttribute(name="registration")
    public Registration register()
    {
        return new Registration();
    }
    @ModelAttribute(name = "register1")
    public Register1 register1() {
        return new Register1();
    }
    @GetMapping
    public String show_register(Model model, @ModelAttribute Register register){
        List<Register1> user =userCredentialsRepository.findByName(register.getName());
        model.addAttribute("user", user);
        model.addAttribute("registration",new Registration());
        return "registration";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/

    @PostMapping
    public String processRegister(@Valid Registration registration, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "registration";
        }
        else
        {
            registrationrepo.save(registration);
            SimpleMailMessage msg=new SimpleMailMessage();
            msg.setTo(registration.getEmail());
            msg.setSubject("Welcome to VoizFonica");
            msg.setText("Hii"+registration.getFirstname()+"\n Your New Connection is done,Your New Number is "+registration.getRand()+"\n thankyou,\n Team VoizFonica");
            javaMail.send(msg);
            return "result";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        /* log.info("Processing design: " + register);*/


    }
}
