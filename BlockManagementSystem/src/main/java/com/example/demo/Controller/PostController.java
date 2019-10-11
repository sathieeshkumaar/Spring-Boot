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
@RequestMapping("/create")
@SessionAttributes("register")
public class PostController {
    private PostRepo postRepo;
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public PostController(PostRepo postRepo,UserCredentialsRepository userCredentialsRepository)
    {
        this.postRepo=postRepo;
        this.userCredentialsRepository=userCredentialsRepository;
    }
    @GetMapping
    public String print(Model model, @ModelAttribute Register register)
    {
        List<Register1> user = new ArrayList<>();
        user=userCredentialsRepository.findByName(register.getName());
        model.addAttribute("user",user);
        model.addAttribute("create",new Create());
        return "message";
    }
    @PostMapping
    public String display(Create create)
    {
        postRepo.save(create);
        return "redirect:/blog";
    }
}
