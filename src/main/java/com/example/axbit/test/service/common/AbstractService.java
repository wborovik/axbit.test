package com.example.axbit.test.service.common;

import com.example.axbit.test.domain.common.AbstractEntity;
import com.example.axbit.test.exception.ObjectNotSavedException;
import com.example.axbit.test.repository.AbstractRepository;
import com.example.axbit.test.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>> {
    protected final R repository;
    protected Class<? extends AbstractEntity> tClass;

    public Page<T> getAllEntities(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Error: object with identifier " + id + " does not exist in the database");
            return new EntityNotFoundException("Entity id not found: " + id);
        });
    }

    public void deleteEntityById(Long id) {
        repository.delete(getEntityById(id));
    }

    public T createEntity(T entity) {
        return Optional.of(repository.save(entity)).orElseThrow(() -> {
            log.error("Error: The object was not saved");
            return new ObjectNotSavedException("The object was not saved");
        });
    }

    public T updateEntityById(Long id, T entity, String... ignoredFields) {
        var entityUpdate = getEntityById(id);
        Utils.copyNonNullProperties(entity, entityUpdate, ignoredFields);
        return createEntity(entityUpdate);
    }
}