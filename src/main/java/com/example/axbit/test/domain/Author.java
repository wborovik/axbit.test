package com.example.axbit.test.domain;

import com.example.axbit.test.domain.common.AuditEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Author extends AuditEntity {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String middleName;
    @Past
    private LocalDate birthDate;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;
}