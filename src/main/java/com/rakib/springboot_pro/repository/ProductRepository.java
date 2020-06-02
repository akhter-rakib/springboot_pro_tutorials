package com.rakib.springboot_pro.repository;

import com.rakib.springboot_pro.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
