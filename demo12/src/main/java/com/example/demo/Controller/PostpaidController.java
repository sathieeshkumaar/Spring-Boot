package com.example.demo.Controller;


import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PostPaidDataRepo;
import com.example.demo.Data.PostRepo;

import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/postpaid")
@SessionAttributes({"order","register","postpaiddata"})
public class PostpaidController {

    private PostRepo postRepo;
    private OrderRepo orderRepo;
    private UserCredentialsRepository userCredentialRepository;
    private PostPaidDataRepo postPaidDataRepo;

    @Autowired
    public PostpaidController(PostRepo postRepo, OrderRepo orderRepo, UserCredentialsRepository userCredentialRepository,PostPaidDataRepo postPaidDataRepo) {
        this.postRepo=postRepo;
        this.orderRepo=orderRepo;
        this.userCredentialRepository=userCredentialRepository;
        this.postPaidDataRepo=postPaidDataRepo;
    }
    @GetMapping
    public String show_register(Model model, @ModelAttribute Register register){
        List<Register1> user = userCredentialRepository.findByName(register.getName());
        model.addAttribute("user", user);
        List<PostPaid> plans = new ArrayList<>();
        postRepo.findAll().forEach(i -> plans.add(i));
        model.addAttribute("plans",plans);
        return "postpaid";
    }
    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name="postpaiddata")
    public PostPaidData pos()
    {
        return new PostPaidData();
    }

    @RequestMapping(value="/{name}" ,method = RequestMethod.GET)
    public String edit(@PathVariable String name, Model m,@ModelAttribute Order order,@SessionAttribute("postpaiddata")PostPaidData postPaiddata){
        List<PostPaid> paid=new ArrayList<>();

        paid=postRepo.getByName(name);

        order.setPostPaid(paid.get(0));
        postPaiddata.setPostpaid(paid.get(0));
        orderRepo.save(order);
        postPaidDataRepo.save(postPaiddata);
        return "redirect:/postpaid/payment2";
    }
    @GetMapping("/payment2")
    public String show_register1(Model model){
        model.addAttribute("payment",new Payment());
        return "payment2";
    }
    @GetMapping("/dashboard")
    public String show_register3(Model model){

        return "redirect:/dashboard";
    }
    @GetMapping("/payment2/success2")
    public String show_register2(Model model){
        model.addAttribute("payment",new Payment());
        return "redirect:/success2";
    }
}
