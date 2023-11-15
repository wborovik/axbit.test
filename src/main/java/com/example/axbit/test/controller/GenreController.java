package com.example.axbit.test.controller;

import com.example.axbit.test.domain.Genre;
import com.example.axbit.test.repository.GenreRepository;
import com.example.axbit.test.service.GenreService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genre")
public class GenreController extends AbstractController<Genre, GenreService, GenreRepository> {
    public GenreController(GenreService service) {
        super(service);
    }

    {
        pageable = PageRequest.of(0, 100, Sort.by("description"));
    }
}