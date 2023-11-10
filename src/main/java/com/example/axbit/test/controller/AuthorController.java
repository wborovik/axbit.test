package com.example.axbit.test.controller;

import com.example.axbit.test.domain.Author;
import com.example.axbit.test.repository.AuthorRepository;
import com.example.axbit.test.service.AuthorService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController extends AbstractController<Author, AuthorService, AuthorRepository> {

    public AuthorController(AuthorService service) {
        super(service);
    }

    private final Pageable PAGEABLE = PageRequest.of(0, 100, Sort.by("firstName"));

    @GetMapping("author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return super.getEntityById(id);
    }

    @DeleteMapping("/author/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable Long id) {
        return super.deleteEntityById(id);
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return super.getAllEntities(PAGEABLE);
    }

    @PostMapping("/author/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return super.createEntity(author);
    }

    @PatchMapping("/author/update/{id}")
    public ResponseEntity<Author> updateAuthorById(@PathVariable Long id, @RequestBody Author author) {
        return super.updateEntityById(id, author);
    }
}