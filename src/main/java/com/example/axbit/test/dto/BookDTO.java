package com.example.axbit.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private String title;
    private String isbn;
    private Long genre;
    private Long author;
}