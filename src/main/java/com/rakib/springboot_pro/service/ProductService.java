package com.rakib.springboot_pro.service;

import com.rakib.springboot_pro.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();

    Product getById(Long id);

    void deletedById(Long id);
}
