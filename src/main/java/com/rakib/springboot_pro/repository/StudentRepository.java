package com.rakib.springboot_pro.repository;

import com.rakib.springboot_pro.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
