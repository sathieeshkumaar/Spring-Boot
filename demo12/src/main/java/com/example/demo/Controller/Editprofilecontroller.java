package com.example.demo.Controller;

import com.example.demo.Data.Editrepo;
import com.example.demo.Data.UserCredentialsRepository;
import com.example.demo.Model.Editprofile;
import com.example.demo.Model.Order;
import com.example.demo.Model.Register;
import com.example.demo.Model.Register1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/editprofile")
@SessionAttributes("register")
public class Editprofilecontroller {

    private UserCredentialsRepository userCredentialRepository;
    private String userId;
    @Autowired
    private Editprofilecontroller(UserCredentialsRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;

    }


    @ModelAttribute(name = "register1")
    public Register1 register1() {
        return new Register1();
    }
    @GetMapping
    public String getEdit(@SessionAttribute("register")Register register, Model model) {

        List<Register1> user = userCredentialRepository.findByName(register.getName());
        System.out.println("dddd"+register.getName());
        model.addAttribute("user", user);
        System.out.println(user);
        return "editprofile";
    }
    @PostMapping
    public String setChanges(@SessionAttribute("register")Register register,@Valid Register1 userCredential, Errors errors, Model model){
        List<Register1> user=userCredentialRepository.findByName(register.getName());
        userId=(String)user.get(0).get_id();
        Register1 user1=new Register1();
        user1.set_id(userId);
        user1.setName(user.get(0).getName());
        user1.setEmail_address(userCredential.getEmail_address());
        user1.setConfirmpassword(user.get(0).getConfirmpassword());
        user1.setPassword(userCredential.getPassword());
        System.out.println(user1);
        userCredentialRepository.save(user1);
        model.addAttribute("user", user);

        return "redirect:/myprofile";

    }
}


/*

@Controller
@RequestMapping("/profileEdit")
public class ProfileEditController {


    private UserCredentialRepository userCredentialRepository;
    private String userId;
    @Autowired
    private ProfileEditController(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;

    }

    @ModelAttribute(name = "userCredential")
    public UserCredential userCredential() {
        return new UserCredential();
    }
    @GetMapping
    public String getEdit(Model model) {

        List<UserCredential> user = userCredentialRepository.findByEmailIdAndPassword("nandhinivishwanathanbe@gmail.com", "nandhini12");
        model.addAttribute("user", user);
        return "profileEdit";
    }
    @PostMapping
    public String setChanges(@Valid UserCredential userCredential, Errors errors, Model model){
        List<UserCredential> user=userCredentialRepository.findUserCredentialByAadharNumberMatches("917703539337");
        userId=(String)user.get(0).getId();
        UserCredential user1=new UserCredential();
        user1.setId(userId);
        user1.setUserName(userCredential.getUserName());
        user1.setContactNumber(userCredential.getContactNumber());
        user1.setAadharNumber(user.get(0).getAadharNumber());
        user1.setAddress(userCredential.getAddress());
        user1.setEmailId(userCredential.getEmailId());
        user1.setPanNumber(user.get(0).getPanNumber());
        user1.setPassword(userCredential.getPassword());
        user1.setRequiredPlan(user.get(0).getRequiredPlan());
        return "redirect:/profile";

    }
    */
/*@PutMapping
    public String finalUpdate(UserCredential userCredential,Model model)
    {
        userCredentialRepository.save(userCredential);
        return "redirect:/customerComplaint";
    }*//*

}
*/
