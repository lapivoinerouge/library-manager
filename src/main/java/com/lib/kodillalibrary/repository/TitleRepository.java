package com.lib.kodillalibrary.repository;

import com.lib.kodillalibrary.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleRepository extends CrudRepository<BookTitle, Long> {
    @Override
    List<BookTitle> findAll();

    @Override
    BookTitle save(BookTitle title);

    @Override
    Optional<BookTitle> findById(Long id);

    @Override
    void deleteById(Long id);

}
