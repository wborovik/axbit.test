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

//    @GetMapping("genre/{id}")
//    public Genre getGenreById(@PathVariable Long id) {
//        return super.getEntityById(id);
//    }

//    @DeleteMapping("/genre/delete/{id}")
//    public ResponseEntity<HttpStatus> deleteGenreById(@PathVariable Long id) {
//        return super.deleteEntityById(id);
//    }

//    @GetMapping
//    public List<Genre> getAllGenres() {
//        return super.getAllEntities(PAGEABLE);
//    }

//    @PostMapping
//    public Genre createGenre(@RequestBody Genre genre) {
//        return super.createEntity(genre);
//    }

//    @PatchMapping("{id}")
//    public Genre updateGenreById(@PathVariable Long id, @RequestBody Genre genre) {
//        return super.updateEntityById(id, genre);
//    }
}