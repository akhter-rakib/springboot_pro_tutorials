package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.entity.Student;
import com.rakib.springboot_pro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String greetingSms(Model model) {
        model.addAttribute("courseName", "Spring Boot Tutorial");
        return "welCome";
    }

    @PostMapping("/saveStudent")
    public void saveStudent(@RequestBody Student student) {
        System.out.println(student.toString());
        studentService.save(student);
    }
}
