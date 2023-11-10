package com.example.axbit.test.domain;

import com.example.axbit.test.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Genre extends AuditEntity {
    @NotNull
    private String description;
}