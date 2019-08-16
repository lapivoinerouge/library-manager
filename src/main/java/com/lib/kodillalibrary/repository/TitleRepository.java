package com.lib.kodillalibrary.repository;

import com.lib.kodillalibrary.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleRepository extends CrudRepository<BookTitle, Long> {
    @Override
    List<BookTitle> findAll();
}
