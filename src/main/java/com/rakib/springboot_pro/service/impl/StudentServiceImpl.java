package com.rakib.springboot_pro.service.impl;

import com.rakib.springboot_pro.entity.Student;
import com.rakib.springboot_pro.repository.StudentRepository;
import com.rakib.springboot_pro.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
