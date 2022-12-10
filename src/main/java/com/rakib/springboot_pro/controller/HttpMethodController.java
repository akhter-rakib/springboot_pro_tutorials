package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.entity.Student;
import com.rakib.springboot_pro.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class HttpMethodController {

    private final StudentService studentService;

    /*When we consider full change/update of a Object then we should go for PutMapping*/
    @PutMapping("/student-full-update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateWholeField(id, student);
    }

    /*When we consider a partial change of an Object then we should go for PatchMatching*/
    @PatchMapping("/student-partial-update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return studentService.updateStudent(id, fields);
    }
}
