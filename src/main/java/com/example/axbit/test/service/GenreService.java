package com.example.axbit.test.service;

import com.example.axbit.test.domain.Genre;
import com.example.axbit.test.repository.GenreRepository;
import com.example.axbit.test.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractService<Genre, GenreRepository> {
    {
        tClass = Genre.class;
    }

    public GenreService(GenreRepository repository) {
        super(repository);
    }
}