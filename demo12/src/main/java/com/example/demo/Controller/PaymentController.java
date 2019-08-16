package com.example.demo.Controller;


import com.example.demo.Data.DongleDataRepo;
import com.example.demo.Data.DongleRepo;
import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PaymentRepository;
import com.example.demo.Model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/payment")
@SessionAttributes({"order","register","dongledata"})
public class PaymentController {
    private PaymentRepository userCredentialsRepository;
    private OrderRepo orderRepo;
    private DongleRepo dongleRepo;
    private DongleDataRepo dongleDataRepo;
    private List<Dongle> dplan=new ArrayList<>();
    @Autowired
    public PaymentController(PaymentRepository userCredentialsRepository,OrderRepo orderRepo,DongleDataRepo dongleDataRepo){
        this.userCredentialsRepository = userCredentialsRepository;
        this.orderRepo=orderRepo;
        this.dongleDataRepo=dongleDataRepo;
    }




    @PostMapping
    public String processRegister(@Valid Payment payment, Errors errors, Model model,@SessionAttribute("dongledata")DongleData dongledata, @ModelAttribute Order order, @ModelAttribute Register register) {
        if (errors.hasErrors()) {
            return "payment";
        }
        else{
            userCredentialsRepository.save(payment);
            order.setPayment(payment);
            dongledata.setPayment(payment);
            dongledata.setUser(register.getName());
            order.setUser(register.getName());
            orderRepo.save(order);
            dongleDataRepo.save(dongledata);
            model.addAttribute("showDetails",payment);
            return "redirect:/dongle/payment/success";
        }


    }

}
