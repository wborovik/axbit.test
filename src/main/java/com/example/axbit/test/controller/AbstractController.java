package com.example.axbit.test.controller;

import com.example.axbit.test.domain.common.AbstractEntity;
import com.example.axbit.test.repository.AbstractRepository;
import com.example.axbit.test.service.common.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService<T, R>, R extends AbstractRepository<T>> {

    protected final S service;
    protected Pageable pageable;

    @GetMapping("{id}")
    public T getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEntityById(@PathVariable Long id) {
        service.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<T> getAllEntities() {
        return service.getAllEntities(pageable).getContent();
    }

    @PostMapping
    public T createEntity(@RequestBody T entity) {
        return service.createEntity(entity);
    }

    @PatchMapping("{id}")
    public T updateEntityById(@PathVariable Long id, @RequestBody T entity) {
        return service.updateEntityById(id, entity);
    }
}