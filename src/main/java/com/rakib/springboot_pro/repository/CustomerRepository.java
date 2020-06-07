package com.rakib.springboot_pro.repository;

import com.rakib.springboot_pro.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByIdAndIsActiveTrue(Long id);

    List<Customer> findAllByIsActiveTrue();
}
