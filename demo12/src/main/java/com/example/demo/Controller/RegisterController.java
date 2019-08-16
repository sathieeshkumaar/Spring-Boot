package com.example.demo.Controller;
        import com.example.demo.Model.*;

        import com.example.demo.Data.UserCredentialsRepository;
        import lombok.extern.slf4j.Slf4j;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.Errors;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.List;

@Slf4j
@Controller
@RequestMapping("/register")
@SessionAttributes({"register","order"})
public class RegisterController {
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    public RegisterController(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @ModelAttribute(name="order")
    public Order order()
    {
        return new Order();
    }
    @ModelAttribute(name="register")
    public Register order1()
    {
        return new Register();
    }
    @GetMapping
    public String show_register(Model model) {
        model.addAttribute("register", new Register());
        return "register";
    }


    @PostMapping
    public String processRegister(@Valid Register register, Errors errors,Model model,@ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "register";
        } else {
            List<Register1> user = userCredentialsRepository.findByNameAndPassword(register.getName(), register.getPassword());

            if (user.isEmpty()) {
                errors.rejectValue("password", "password.invalid", "Invalid password or username");
                return "register";
            } else {
             model.addAttribute("user", user);
                return "redirect:/dashboard";
            }


        }
    }

}