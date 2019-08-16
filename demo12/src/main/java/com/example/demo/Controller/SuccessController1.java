package com.example.demo.Controller;

import com.example.demo.Data.OrderRepo;
import com.example.demo.Model.Order;
import com.example.demo.Model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/success1")
@SessionAttributes({"order","register"})
public class SuccessController1 {
    private OrderRepo orderRepo;
    @Autowired
    public SuccessController1(OrderRepo orderRepo)
    {
        this.orderRepo=orderRepo;
    }
    @GetMapping
    @ModelAttribute
    public String print(@ModelAttribute Register register, Model model,@ModelAttribute Order order)
    {
        //List<Order> bill=new ArrayList<>();
        // bill=orderRepo.getByUser(register.getName());
        model.addAttribute("bill",order);
        return "success1";

    }
}

