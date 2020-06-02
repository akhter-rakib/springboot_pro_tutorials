package com.rakib.springboot_pro.service.impl;

import com.rakib.springboot_pro.entity.Product;
import com.rakib.springboot_pro.repository.ProductRepository;
import com.rakib.springboot_pro.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deletedById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent() && productOptional.get() != null) {
            Product product = productOptional.get();
            productRepository.delete(product);
        }
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent() && productOptional.get() != null) {
            return productOptional.get();
        }
        return null;
    }

}
