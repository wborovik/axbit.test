package com.example.axbit.test.service;

import com.example.axbit.test.domain.Author;
import com.example.axbit.test.repository.AuthorRepository;
import com.example.axbit.test.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractService<Author, AuthorRepository> {
    {
        tClass = Author.class;
    }

    public AuthorService(AuthorRepository repository) {
        super(repository);
    }
}