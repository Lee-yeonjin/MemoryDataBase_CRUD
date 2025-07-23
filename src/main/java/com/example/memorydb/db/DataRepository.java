package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T,ID> extends Repository<T, ID> {

    // create
    T save(T data);

    // read
    Optional findById(ID id);

    // read
    //Optional<T> findByID(ID id);

    List<T> findAll();

    // delete
    void delete(ID id);
}