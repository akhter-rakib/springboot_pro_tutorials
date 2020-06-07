package com.rakib.springboot_pro.service.impl;

import com.rakib.springboot_pro.dto.CustomerDto;
import com.rakib.springboot_pro.dto.Response;
import com.rakib.springboot_pro.entity.Customer;
import com.rakib.springboot_pro.repository.CustomerRepository;
import com.rakib.springboot_pro.service.CustomerService;
import com.rakib.springboot_pro.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final String root = "Product";

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer = customerRepository.save(customer);
        if (customer != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Customer Has Bean Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findByIdAndIsActiveTrue(id);
        if (customer != null) {
            customer = modelMapper.map(customerDto, Customer.class);
            customer = customerRepository.save(customer);
            if (customer != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "Customer update Successfully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + "Not Found");
    }

    @Override
    public Response delete(Long id) {
        Customer customer = customerRepository.findByIdAndIsActiveTrue(id);
        if (customer != null) {
            customer.setIsActive(false);
            customer = customerRepository.save(customer);
            if (customer != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Deleted Successfully", null);
            } else {
                return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, root + "Internal Server Error");
            }
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " Not found");
    }

    @Override
    public Response getAll() {
        List<Customer> customers = customerRepository.findAllByIsActiveTrue();
        List<CustomerDto> customerDtoList = getCustomers(customers);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Retrieve Successfully", customerDtoList);
    }

    public List<CustomerDto> getCustomers(List<Customer> customers) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        customers.forEach(customer -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDtos.add(customerDto);
        });
        return customerDtos;
    }

    @Override
    public Response get(Long id) {
        Customer customer = customerRepository.findByIdAndIsActiveTrue(id);
        if (customer != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.FOUND, root + "retrieved Successfully", customerDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }
}
