package com.example.axbit.test.domain;

import com.example.axbit.test.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Book extends AuditEntity {
    private String title;
    @ISBN
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private Author author;
}