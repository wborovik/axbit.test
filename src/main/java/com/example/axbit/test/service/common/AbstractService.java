package com.example.axbit.test.service.common;

import com.example.axbit.test.domain.common.AbstractEntity;
import com.example.axbit.test.exception.EntityNotFoundException;
import com.example.axbit.test.exception.ObjectNotSavedException;
import com.example.axbit.test.repository.AbstractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>> {
    protected final R repository;

    public Page<T> getAllEntities(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T getEntityById(Long id) {
        try {
            return repository.findById(id).orElseThrow(RuntimeException::new);
        } catch (RuntimeException ex) {
            log.error("Error: object with identifier " + id + " does not exist in the database");
            throw new EntityNotFoundException("Entity id not found: " + id);
        }
    }

    public void deleteEntityById(Long id) {
        repository.delete(getEntityById(id));
    }

    public T createEntity(T entity) {
        try {
            return repository.save(entity);
        } catch (Exception ex) {
            log.error("Error: The object was not saved");
            throw new ObjectNotSavedException("The object was not saved");
        }
    }

    public abstract T updateEntityById(Long id, T entity);
}