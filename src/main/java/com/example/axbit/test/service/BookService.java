package com.example.axbit.test.service;

import com.example.axbit.test.domain.Book;
import com.example.axbit.test.dto.BookDTO;
import com.example.axbit.test.repository.BookRepository;
import com.example.axbit.test.service.common.AbstractService;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class BookService extends AbstractService<Book, BookRepository> {

    private final AuthorService authorService;
    private final GenreService genreService;

    public BookService(BookRepository repository, AuthorService authorService, GenreService genreService) {
        super(repository);
        this.authorService = authorService;
        this.genreService = genreService;
    }

    public Book mapBookDTO(BookDTO bookDTO, Book book) {
        ofNullable(bookDTO.getTitle()).ifPresent(book::setTitle);
        ofNullable(bookDTO.getIsbn()).ifPresent(book::setIsbn);
        ofNullable(bookDTO.getAuthorId()).ifPresent(id -> book.setAuthor(authorService.getEntityById(id)));
        ofNullable(bookDTO.getGenreId()).ifPresent(id -> book.setGenre(genreService.getEntityById(id)));

        return book;
    }

    @Override
    public Book updateEntityById(Long id, Book book) {
        return createEntity(book);
    }
}