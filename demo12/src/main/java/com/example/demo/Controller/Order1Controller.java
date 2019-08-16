package com.example.demo.Controller;

import com.example.demo.Data.*;
import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/orders1")
@SessionAttributes("register")
public class Order1Controller {
    private UserCredentialsRepository userCredentialRepository;
    private Registrationrepo registrationrepo;
    private DongleDataRepo dongleDataRepo;
    private PostPaidDataRepo postPaidDataRepo;
    private PrePaidDataRepo prePaidDataRepo;

    @Autowired
    private Order1Controller(DongleDataRepo dongleDataRepo,PrePaidDataRepo prePaidDataRepo,PostPaidDataRepo postPaidDataRepo,UserCredentialsRepository userCredentialRepository,Registrationrepo registrationrepo) {
        this.userCredentialRepository = userCredentialRepository;
        this.registrationrepo=registrationrepo;
        this.dongleDataRepo=dongleDataRepo;
        this.postPaidDataRepo=postPaidDataRepo;
        this.prePaidDataRepo=prePaidDataRepo;

    }
    @ModelAttribute(name = "register1")
    public Register1 register1() {
        return new Register1();
    }
    @GetMapping
    public String newProfile(@SessionAttribute("register") Register register, Model model){
        List<Register1> user = userCredentialRepository.findByName(register.getName());
        List<DongleData> dongle=dongleDataRepo.getByUser(register.getName());
        System.out.println(dongle);
        List<PostPaidData> postpaid=postPaidDataRepo.getByUser(register.getName());
        List<PrePaidData> prepaid=prePaidDataRepo.getByUser(register.getName());
        model.addAttribute("user", user);
        model.addAttribute("dongle", dongle);
        model.addAttribute("prepaid", prepaid);
        model.addAttribute("postpaid", postpaid);
        return "orders1";

    }
}
