package com.example.axbit.test.controller;

import com.example.axbit.test.domain.Book;
import com.example.axbit.test.dto.BookDTO;
import com.example.axbit.test.repository.BookRepository;
import com.example.axbit.test.service.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController extends AbstractController<Book, BookService, BookRepository> {

    public BookController(BookService service) {
        super(service);
    }

    private final Pageable PAGEABLE = PageRequest.of(0, 100, Sort.by("title"));

    @GetMapping("book/{id}")
    public ResponseEntity<Book> geBookById(@PathVariable Long id) {
        return super.getEntityById(id);
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id) {
        return super.deleteEntityById(id);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return super.getAllEntities(PAGEABLE);
    }

    @PostMapping("/book/create")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        return super.createEntity(service.mapBookDTO(bookDTO, new Book()));
    }

    @PatchMapping("/book/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return super.updateEntityById(id, service.mapBookDTO(bookDTO, service.getEntityById(id)));
    }
}