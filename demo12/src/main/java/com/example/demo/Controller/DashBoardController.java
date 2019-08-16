package com.example.demo.Controller;

import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PrePaidDataRepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.Order;
import com.example.demo.Model.PrePaidData;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/dashboard")
@SessionAttributes("register")
public class DashBoardController {

    private UserCredentialsRepository userCredentialRepository;
    private OrderRepo orderRepo;
    private PrePaidDataRepo prePaidDataRepo;
    private String userId;
    @Autowired
    private DashBoardController(PrePaidDataRepo prePaidDataRepo,UserCredentialsRepository userCredentialRepository,OrderRepo orderRepo) {
        this.userCredentialRepository = userCredentialRepository;
        this.orderRepo=orderRepo;
        this.prePaidDataRepo=prePaidDataRepo;

    }

    @ModelAttribute(name = "register1")
    public Register1 register1() {
        return new Register1();
    }
    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @GetMapping
    public String getEdit(@SessionAttribute("register")Register register, Model model) {

        List<Register1> user = userCredentialRepository.findByName(register.getName());
        model.addAttribute("user", user);
        List<PrePaidData> data = prePaidDataRepo.getByUser(register.getName());

        model.addAttribute("data", data);
        return "dashboard";
    }

    @GetMapping("/dongle")
    public String show_register2(){
        /*List<Register1> user = userCredentialRepository.findByName(register.getName());
        model.addAttribute("user", user);*/

        return "redirect:/dongle";

    }
}
