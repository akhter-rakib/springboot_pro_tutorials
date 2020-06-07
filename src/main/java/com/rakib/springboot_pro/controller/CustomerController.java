package com.rakib.springboot_pro.controller;

import com.rakib.springboot_pro.ApiController;
import com.rakib.springboot_pro.dto.CustomerDto;
import com.rakib.springboot_pro.dto.Response;
import com.rakib.springboot_pro.service.CustomerService;
import com.rakib.springboot_pro.util.ResponseBuilder;
import com.rakib.springboot_pro.util.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.CustomerManagement.ROOT)
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = UrlConstraint.CustomerManagement.CREATE)
    public Response create(@Valid @RequestBody CustomerDto customerDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseBuilder.getFailureResponse(result, "Bean Binding Error");
        }
        return customerService.save(customerDto);
    }

    @GetMapping(value = UrlConstraint.CustomerManagement.GET_ALL)
    public Response list() {
        return customerService.getAll();
    }

    @PutMapping(value = UrlConstraint.CustomerManagement.UPDATE)
    public Response update(@PathVariable("id") Long id, @Valid @RequestBody CustomerDto customerDto, BindingResult result) {
        if (result.hasErrors()) {
            ResponseBuilder.getFailureResponse(result, "Bean Binding Error");
        }
        return customerService.update(id, customerDto);
    }

    @DeleteMapping(UrlConstraint.CustomerManagement.DELETE)
    public Response delCustomer(@PathVariable("id") Long id) {
        return customerService.delete(id);
    }

    @GetMapping(UrlConstraint.CustomerManagement.GET)
    public Response get(@PathVariable("id") Long id) {
        return customerService.get(id);
    }
}
