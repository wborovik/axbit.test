package com.example.axbit.test.repository;

import com.example.axbit.test.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends AbstractRepository<Book> {
}