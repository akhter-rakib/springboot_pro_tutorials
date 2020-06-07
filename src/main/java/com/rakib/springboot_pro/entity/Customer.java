package com.rakib.springboot_pro.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Customer extends BaseModel {
    private String name;
    private int idNo;
    private String address;
}
