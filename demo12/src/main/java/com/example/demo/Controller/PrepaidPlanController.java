package com.example.demo.Controller;

import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PrePaidDataRepo;
import com.example.demo.Data.PrepaidPlanRepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/prepaid")
@SessionAttributes({"order","register","prepaiddata"})
public class PrepaidPlanController {

    private PrepaidPlanRepo preRepo;
    private OrderRepo orderRepo;
    private UserCredentialsRepository userCredentialRepository;
    private PrePaidDataRepo prePaidDataRepo;

    @Autowired
    public PrepaidPlanController(PrePaidDataRepo prePaidDataRepo,PrepaidPlanRepo preRepo, OrderRepo orderRepo, UserCredentialsRepository userCredentialRepository)
    {
        this.preRepo=preRepo;
        this.orderRepo=orderRepo;
        this.userCredentialRepository=userCredentialRepository;
        this.prePaidDataRepo=prePaidDataRepo;
    }
    @GetMapping
    public String show_register(Model model, @ModelAttribute Register register){
        List<Register1> user = userCredentialRepository.findByName(register.getName());
        model.addAttribute("user", user);
        List<PrepaidPlan> plans = new ArrayList<>();
        preRepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "prepaid";
    }
    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name="prepaiddata")
    public PrePaidData pre()
    {
        return new PrePaidData();
    }

    @RequestMapping(value="/{name}" ,method = RequestMethod.GET)
    public String edit(@PathVariable String name, Model m, @ModelAttribute Order order,@SessionAttribute("prepaiddata")PrePaidData prepaiddata){
        List<PrepaidPlan> prepaids=new ArrayList<>();
        prepaids=preRepo.getByName(name);
        order.setPrepaidplan(prepaids.get(0));
        prepaiddata.setPrepaid(prepaids.get(0));
        orderRepo.save(order);
       // prePaidDataRepo.save(prepaiddata);
        return "redirect:/prepaid/payment1";
    }
    @GetMapping("/payment1")
    public String show_register1(Model model){
        model.addAttribute("payment",new Payment());
        return "payment1";
    }
    @GetMapping("/dashboard")
    public String show_register3(Model model){

        return "redirect:/dashboard";
    }
    @GetMapping("/payment1/success1")
    public String show_register2(Model model){
        model.addAttribute("payment",new Payment());
        return "redirect:/success1";
    }
}
