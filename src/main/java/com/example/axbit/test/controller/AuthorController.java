package com.example.axbit.test.controller;

import com.example.axbit.test.domain.Author;
import com.example.axbit.test.repository.AuthorRepository;
import com.example.axbit.test.service.AuthorService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController extends AbstractController<Author, AuthorService, AuthorRepository> {
    public AuthorController(AuthorService service) {
        super(service);
    }
    {
        pageable = PageRequest.of(0, 100, Sort.by("lastName"));
    }


//    private final Pageable PAGEABLE = PageRequest.of(0, 100, Sort.by("lastName"));

//    @GetMapping("{id}")
//    public Author getAuthorById(@PathVariable Long id) {
//        return super.getEntityById(id);
//    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable Long id) {
//        return super.deleteEntityById(id);
//    }

//    @GetMapping
//    public List<Author> getAllAuthors() {
//        return super.getAllEntities(PAGEABLE);
//    }

//    @PostMapping
//    public Author createAuthor(@RequestBody Author author) {
//        return super.createEntity(author);
//    }

//    @PatchMapping("{id}")
//    public Author updateAuthorById(@PathVariable Long id, @RequestBody Author author) {
//        return super.updateEntityById(id, author);
//    }
}