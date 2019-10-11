package com.example.demo.Controller;

import com.example.demo.Data.PostRepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.Create;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("register")
@RequestMapping("/blog")
public class BlogController {
    private PostRepo postRepo;
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public BlogController(PostRepo postRepo,UserCredentialsRepository userCredentialsRepository)
    {
        this.postRepo=postRepo;
        this.userCredentialsRepository=userCredentialsRepository;
    }
    @ModelAttribute
    @GetMapping
    public String Display(@ModelAttribute Register register, Model model)
    {
        List<Create> plans = new ArrayList<>();
        List<Register1> user = new ArrayList<>();
        user=userCredentialsRepository.findByName(register.getName());
        plans=postRepo.findByName(register.getName());
        model.addAttribute("plans",plans);
        model.addAttribute("user",user);
        return "blog";
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable String id){
        System.out.println(id);
        postRepo.deleteBy_id(id);
        return "redirect:/blog";
    }
}
