package com.example.demo.Controller;

import com.example.demo.Data.SearchRepo;
import com.example.demo.Model.Order;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController {
    private SearchRepo searchrepo;
    @Autowired
    public OrderController(SearchRepo searchrepo)
    {
        this.searchrepo=searchrepo;
    }
    @RequestMapping(value = "/search")
  public String search(Model model, @RequestParam String search) {
        model.addAttribute("carList", searchrepo.searchCars(search));
        if (searchrepo.searchCars(search).isEmpty()) {

            return "order";
        }
        model.addAttribute("search", search);
        return "order";
    }

}

