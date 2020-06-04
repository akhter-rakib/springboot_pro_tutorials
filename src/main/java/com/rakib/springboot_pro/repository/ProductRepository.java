package com.rakib.springboot_pro.repository;

import com.rakib.springboot_pro.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select product from Product product where product.activeStatus=(:activeStatus)")
    List list(@Param("activeStatus") Integer activeStatus);

}
