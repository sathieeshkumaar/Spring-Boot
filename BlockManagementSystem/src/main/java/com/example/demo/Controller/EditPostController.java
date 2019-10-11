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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/edit")
@SessionAttributes("register")
public class EditPostController {
    private PostRepo postRepo;
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public EditPostController(PostRepo postRepo,UserCredentialsRepository userCredentialsRepository)
    {
        this.postRepo=postRepo;
        this.userCredentialsRepository=userCredentialsRepository;
    }
   @GetMapping(value="/{_id}")
    public String print(@PathVariable String _id, Model m, @ModelAttribute Register register) {
       List<Create> ed = new ArrayList<>();
       ed = postRepo.findBy_id(_id);
       System.out.println(ed);
       List<Register1> user = new ArrayList<>();
       user=userCredentialsRepository.findByName(register.getName());
       m.addAttribute("user",user);
       m.addAttribute("create",new Create());
       m.addAttribute("edit", ed);
       return "edit";
   }
   @GetMapping("/")
   public String out()
   {
       return "redirect:/";
   }
   @GetMapping("/blog")
   public String Pro()
   {
       return "redirect:/blog";
   }
  @PostMapping(value="/{_id}")
    public String display(@PathVariable String _id, Create create)
  {
      Create c= postRepo.findAllBy_id(_id);

       c.setName(create.getName());
       c.setTitle(create.getTitle());
       c.setSummary(create.getSummary());
       c.setMessage(create.getMessage());
       postRepo.save(c);
       return "redirect:/blog";

  }
}

