package com.rakib.springboot_pro.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String cratedBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    private Boolean isActive;

    @PrePersist
    public void setPreInsertData() {
        this.createdAt = new Date();
        this.isActive = true;
    }

    @PreUpdate
    public void setPreUpdateData() {
        this.updatedAt = new Date();
    }

}
