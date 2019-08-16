package com.example.demo.Controller;


import com.example.demo.Data.InvoiceRepository;
import com.example.demo.Model.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository){
        this.invoiceRepository=invoiceRepository;
    }

    /*public String show_register(Model model){
         List<Register> mylist= Arrays.asList(
                 new register("varnika",999,"varnika@gmail.com","****")
         );
         model.addAttribute("account",mylist);

         return "register";

     }*/
    @ModelAttribute(name="invoice")
    public Invoice register(){
        return new Invoice();
    }
    @GetMapping
    public String show_register(Model model){
        model.addAttribute("invoice",new Invoice());
        return "invoice";
    }
/*
@GetMapping("/register")
public String showRegister(){
    return "register";
}
*/

    @PostMapping
    public String processRegister(@Valid Invoice invoice, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "invoice";
        }
        else
        {
            invoiceRepository.save(invoice);
            //model.addAttribute("show_register",invoice);
            return "invoice_print";
        }

        // Save the taco design...
        // We'll do this in chapter 3
        /* log.info("Processing design: " + register);*/

        //return "invoice";
    }
}
