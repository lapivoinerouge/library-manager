package com.lib.kodillalibrary.repository;

import com.lib.kodillalibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();
}
