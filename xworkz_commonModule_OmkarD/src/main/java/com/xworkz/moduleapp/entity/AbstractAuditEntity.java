package com.xworkz.moduleapp.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AbstractAuditEntity {

    private String createdBy;
    private LocalDateTime createdDateAndTime;
    private String updatedBy;
    private LocalDateTime updatedDateAndTime;
}
