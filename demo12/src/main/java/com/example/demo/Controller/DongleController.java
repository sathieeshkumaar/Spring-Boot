package com.example.demo.Controller;

import com.example.demo.Data.DongleDataRepo;
import com.example.demo.Data.DongleRepo;
import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dongle")
@SessionAttributes({"order","register","dongledata"})
public class DongleController {

    private DongleRepo donglerepo;
    private OrderRepo orderRepo;
    private UserCredentialsRepository userCredentialRepository;
    private String userId;
    private DongleDataRepo dongleDataRepo;
    List<Dongle> dongles=new ArrayList<>();

    @ModelAttribute(name = "register1")
    public Register1 register1() {
        return new Register1();
    }


    @Autowired
    public DongleController(DongleDataRepo dongleDataRepo,DongleRepo dongleRepo,OrderRepo orderRepo,UserCredentialsRepository userCredentialRepository) {
        this.donglerepo=dongleRepo;
        this.userCredentialRepository = userCredentialRepository;
        this.dongleDataRepo=dongleDataRepo;
        this.orderRepo=orderRepo;
    }


    @GetMapping
    public String show_register(Model model,@ModelAttribute Register register){
        List<Register1> user = userCredentialRepository.findByName(register.getName());
        model.addAttribute("user", user);
        List<Dongle> plans = new ArrayList<>();
        donglerepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "dongle";
    }
    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name="dongledata")
    public DongleData dat() {
        return new DongleData();
    }

    @RequestMapping(value="/{name}" ,method = RequestMethod.GET)
    public String edit(@PathVariable String name, Model m,@ModelAttribute Order order,@SessionAttribute("dongledata")DongleData dongledata){
       // List<Dongle> dongles=new ArrayList<>();
        dongles=donglerepo.getByName(name);
        dongledata.setDongle(dongles.get(0));
        dongleDataRepo.save(dongledata);
        System.out.println(dongles);
        order.setDongle(dongles.get(0));
        orderRepo.save(order);
        return "redirect:/dongle/payment";
    }

    @GetMapping("/payment")
    public String show_register1(Model model){
        model.addAttribute("payment",new Payment());
        return "payment";
    }
    @GetMapping("/dashboard")
    public String show_register3(Model model){

        return "redirect:/dashboard";
    }
    @GetMapping("/payment/success")
    public String show_register2(Model model){
        model.addAttribute("payment",new Payment());
        return "redirect:/success";
    }

}
