package com.rakib.springboot_pro.service;

import com.rakib.springboot_pro.dto.CustomerDto;
import com.rakib.springboot_pro.dto.Response;

public interface CustomerService {
    Response save(CustomerDto customerDto);

    Response update(Long id, CustomerDto customerDto);

    Response delete(Long id);

    Response getAll();

    Response get(Long id);
}
