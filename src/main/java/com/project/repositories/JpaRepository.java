package com.project.repositories;

import java.util.List;
import java.util.Optional;

public interface JpaRepository <T, ID> {

    List<T> findAll();
    Optional<T> findById(ID id);
    Optional<T> save(T object);
    Optional<T> update(T object);
    void delete(ID id);
}
