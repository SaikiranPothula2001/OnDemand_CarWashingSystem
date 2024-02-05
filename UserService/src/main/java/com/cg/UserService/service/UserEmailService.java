package com.cg.UserService.service;
import java.util.Properties; // Import Properties class from java.util

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class UserEmailService {
    @Autowired
    JavaMailSender mail;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        //message.setFrom("SpringBootDemoApplication@gmail.com");
        message.setFrom("pothulasaikiran@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        // Enable STARTTLS for a secure connection
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) mail;
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        mail.send(message);

        System.out.println("Mail sent successfully...");
    }
}
