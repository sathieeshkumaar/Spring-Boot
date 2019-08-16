package com.example.demo.Controller;


import com.example.demo.Data.DongleRepo;
import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PaymentRepository;
import com.example.demo.Data.PrePaidDataRepo;
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
@RequestMapping("/payment1")
@SessionAttributes({"order","register","prepaiddata"})
public class PaymentController1 {
    private PaymentRepository userCredentialsRepository;
    private OrderRepo orderRepo;
    private PrePaidDataRepo prePaidDataRepo;
    //private DongleRepo dongleRepo;
    //private List<Dongle> dplan=new ArrayList<>();
    @Autowired
    public PaymentController1(PaymentRepository userCredentialsRepository,OrderRepo orderRepo,PrePaidDataRepo prePaidDataRepo){
        this.userCredentialsRepository = userCredentialsRepository;
        this.orderRepo=orderRepo;
        this.prePaidDataRepo=prePaidDataRepo;
    }




    @PostMapping
    public String processRegister(@Valid Payment payment, Errors errors, Model model,@SessionAttribute("prepaiddata")PrePaidData prepaiddata, @ModelAttribute Order order, @ModelAttribute Register register) {
        if (errors.hasErrors()) {
            return "payment1";
        }
        else{
            userCredentialsRepository.save(payment);
            order.setPayment(payment);
            order.setUser(register.getName());
            orderRepo.save(order);
            prepaiddata.setPayment(payment);
           //System.out.println(prepaiddata.getPrepaid().getName());
            prepaiddata.setUser(register.getName());
            prePaidDataRepo.save(prepaiddata);
            model.addAttribute("showDetails",payment);
            return "redirect:/prepaid/payment1/success1";
        }


    }

}

