package com.rakib.springboot_pro.service;

import com.rakib.springboot_pro.entity.Student;

import java.util.Map;

public interface StudentService {

    void save(Student student);

    Student updateStudent(Long id, Map<String, Object> fields);

    Student updateWholeField(Long id, Student student);
}
