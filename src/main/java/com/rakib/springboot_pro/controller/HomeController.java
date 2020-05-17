package com.rakib.springboot_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String greetingSms(Model model) {
        model.addAttribute("courseName", "Spring Boot Tutorial");
        return "welCome";
    }
}
