package com.example.axbit.test.domain.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity extends AbstractEntity {
    @NotNull
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime changed;

    @PrePersist
    private void prePersist() {
        if (Objects.nonNull(changed) && changed.equals(created)) {
            changed = null;
        }
    }

    @PreUpdate
    private void preUpdate() {
        prePersist();
    }
}