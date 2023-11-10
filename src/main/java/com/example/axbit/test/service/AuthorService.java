package com.example.axbit.test.service;

import com.example.axbit.test.domain.Author;
import com.example.axbit.test.repository.AuthorRepository;
import com.example.axbit.test.service.common.AbstractService;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class AuthorService extends AbstractService<Author, AuthorRepository> {

    public AuthorService(AuthorRepository repository) {
        super(repository);
    }

    @Override
    public Author updateEntityById(Long id, Author author) {
        Author authorUpdate = getEntityById(id);
        ofNullable(author.getFirstName()).ifPresent(authorUpdate::setFirstName);
        ofNullable(author.getLastName()).ifPresent(authorUpdate::setLastName);
        ofNullable(author.getMiddleName()).ifPresent(authorUpdate::setMiddleName);
        ofNullable(author.getBirthDate()).ifPresent(authorUpdate::setBirthDate);

        return createEntity(authorUpdate);
    }
}