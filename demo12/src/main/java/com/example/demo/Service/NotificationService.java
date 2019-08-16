package com.example.demo.Service;

import com.example.demo.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("registration")
@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(@ModelAttribute Registration registration) throws MailException {
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(registration.getEmail());
        mail.setFrom("sathieeshkumaar.iprimed@gmail.com");
        mail.setSubject("New user to our family!!!");
        mail.setText("VoizFonica at your service");

        javaMailSender.send(mail);
    }
}
