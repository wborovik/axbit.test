package com.example.axbit.test.service;

import com.example.axbit.test.domain.Genre;
import com.example.axbit.test.repository.GenreRepository;
import com.example.axbit.test.service.common.AbstractService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService extends AbstractService<Genre, GenreRepository> {
    public GenreService(GenreRepository repository) {
        super(repository);
    }

    @Override
    public Genre updateEntityById(Long id, Genre genre) {
        var genreUpdate = getEntityById(id);
        Optional.ofNullable(genre.getDescription()).ifPresent(genreUpdate::setDescription);

        return createEntity(genreUpdate);
    }
}