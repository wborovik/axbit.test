package com.example.axbit.test.controller;

import com.example.axbit.test.domain.Book;
import com.example.axbit.test.dto.BookDTO;
import com.example.axbit.test.repository.BookRepository;
import com.example.axbit.test.service.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController extends AbstractController<Book, BookService, BookRepository> {

    public BookController(BookService service) {
        super(service);
    }

    {
        pageable = PageRequest.of(0, 100, Sort.by("title"));
    }

    @PostMapping("new")
    public Book createBook(@RequestBody BookDTO bookDTO) {
        return service.createEntity(service.mapBookDTO(bookDTO, new Book()));
    }

    @PatchMapping("new/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return service.updateEntityById(id, service.mapBookDTO(bookDTO, service.getEntityById(id)));
    }
}