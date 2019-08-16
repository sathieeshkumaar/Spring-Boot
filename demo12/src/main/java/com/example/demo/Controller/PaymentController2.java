package com.example.demo.Controller;



import com.example.demo.Data.DongleRepo;
import com.example.demo.Data.OrderRepo;
import com.example.demo.Data.PaymentRepository;
import com.example.demo.Data.PostPaidDataRepo;
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
@RequestMapping("/payment2")
@SessionAttributes({"order","register","postpaiddata"})
public class PaymentController2 {
    private PaymentRepository userCredentialsRepository;
    private OrderRepo orderRepo;
    private PostPaidDataRepo postPaidDataRepo;
    //private DongleRepo dongleRepo;
    //private List<Dongle> dplan=new ArrayList<>();
    @Autowired
    public PaymentController2(PaymentRepository userCredentialsRepository,OrderRepo orderRepo,PostPaidDataRepo postPaidDataRepo){
        this.userCredentialsRepository = userCredentialsRepository;
        this.postPaidDataRepo=postPaidDataRepo;
        this.orderRepo=orderRepo;
    }




    @PostMapping
    public String processRegister(@Valid Payment payment, Errors errors, Model model, @SessionAttribute("postpaiddata") PostPaidData postPaiddata,@ModelAttribute Order order, @ModelAttribute Register register) {
        if (errors.hasErrors()) {
            return "payment2";
        }
        else{
            userCredentialsRepository.save(payment);
            order.setPayment(payment);
            order.setUser(register.getName());
            postPaiddata.setPayment(payment);
            postPaiddata.setUser(register.getName());
            orderRepo.save(order);
            postPaidDataRepo.save(postPaiddata);
            model.addAttribute("showDetails",payment);
            return "redirect:/postpaid/payment2/success2";
        }


    }

}


