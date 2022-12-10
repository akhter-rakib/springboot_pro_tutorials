package com.rakib.springboot_pro.service.impl;

import com.rakib.springboot_pro.entity.Student;
import com.rakib.springboot_pro.repository.StudentRepository;
import com.rakib.springboot_pro.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Map<String, Object> fields) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            fields.forEach((k, v) -> {
                Field field = ReflectionUtils.findField(Student.class, k);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingStudent.get(), v);
            });
            return existingStudent.get();
        }
        return null;
    }

    @Override
    public Student updateWholeField(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student std = existingStudent.get();
            std.setName(student.getName());
            std.setMobileNo(student.getMobileNo());
            std.setRollNo(student.getRollNo());
            return studentRepository.save(std);
        }
        return null;
    }
}
