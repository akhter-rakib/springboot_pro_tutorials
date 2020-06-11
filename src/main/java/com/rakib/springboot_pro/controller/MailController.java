package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.service.MailService;
import com.rakib.springboot_pro.service.StudentService;
import com.rakib.springboot_pro.util.EmailStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    private final MailService mailService;

    public MailController(StudentService studentService, MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendMail")
    public EmailStatus sendMail() {
        String to[] = {"rakibccj@gmail.com"};
        return mailService.sendNonHtmlMail(to, "To check You are sleeping or not", "Keep in Touch Bro ! ");
    }
}
