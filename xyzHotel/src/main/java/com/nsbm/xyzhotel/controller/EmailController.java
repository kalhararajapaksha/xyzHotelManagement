package com.nsbm.xyzhotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping
    public boolean sendEmail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo("kasunkrajapaksha@gmail.com");
            mimeMessageHelper.setText("Test Email.......!", true);
            mimeMessageHelper.setSubject("Testing");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }


}
