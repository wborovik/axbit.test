package com.example.axbit.test.controller;

import com.example.axbit.test.domain.common.AbstractEntity;
import com.example.axbit.test.repository.AbstractRepository;
import com.example.axbit.test.service.common.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService<T, R>, R extends AbstractRepository<T>> {

    protected final S service;

    public ResponseEntity<T> getEntityById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getEntityById(id), HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteEntityById(@PathVariable Long id) {
        service.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<T>> getAllEntities(Pageable pageable) {
        return new ResponseEntity<>(service.getAllEntities(pageable).getContent(), HttpStatus.OK);
    }

    public ResponseEntity<T> createEntity(@RequestBody T entity) {
        service.createEntity(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    public ResponseEntity<T> updateEntityById(@PathVariable Long id, @RequestBody T entity) {
        return new ResponseEntity<>(service.updateEntityById(id, entity), HttpStatus.OK);
    }
}