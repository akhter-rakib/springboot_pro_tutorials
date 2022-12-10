package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.entity.Student;
import com.rakib.springboot_pro.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HomeController {

    private final StudentService studentService;

    @GetMapping("/")
    public String greetingSms(Model model) {
        model.addAttribute("courseName", "Spring Boot Tutorial");
        return "welCome";
    }

    @PostMapping("/save-student")
    public void saveStudent(@RequestBody Student student) {
        log.info(student.toString());
        studentService.save(student);
    }
}
