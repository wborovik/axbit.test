package com.example.axbit.test.controller;

import com.example.axbit.test.domain.Genre;
import com.example.axbit.test.repository.GenreRepository;
import com.example.axbit.test.service.GenreService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController extends AbstractController<Genre, GenreService, GenreRepository> {
    public GenreController(GenreService service) {
        super(service);
    }

    private final Pageable PAGEABLE = PageRequest.of(0, 100, Sort.by("description"));

    @GetMapping("genre/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        return super.getEntityById(id);
    }

    @DeleteMapping("/genre/delete/{id}")
    public ResponseEntity<HttpStatus> deleteGenreById(@PathVariable Long id) {
        return super.deleteEntityById(id);
    }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return super.getAllEntities(PAGEABLE);
    }

    @PostMapping("/genre/create")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        return super.createEntity(genre);
    }

    @PatchMapping("/genre/update/{id}")
    public ResponseEntity<Genre> updateGenreById(@PathVariable Long id, @RequestBody Genre genre) {
        return super.updateEntityById(id, genre);
    }
}