package com.lib.kodillalibrary.repository;

import com.lib.kodillalibrary.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReaderRepository extends CrudRepository<Reader, Long> {
    @Override
    List<Reader> findAll();
}
