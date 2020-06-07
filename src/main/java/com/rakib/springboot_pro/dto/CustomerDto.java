package com.rakib.springboot_pro.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CustomerDto {
    private Long id;
    @NotBlank(message = "Name is Mendatory")
    private String name;
    private int idNo;
    private String address;
}
