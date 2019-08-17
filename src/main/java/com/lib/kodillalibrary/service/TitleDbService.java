package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.BookTitle;
import com.lib.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleDbService {

    @Autowired
    private TitleRepository repository;

    public List<BookTitle> getAllTitles() {
        return repository.findAll();
    }

    public Optional<BookTitle> getTitle(final Long id) {
        return repository.findById(id);
    }

    public BookTitle saveTitle(final BookTitle title) {
        return repository.save(title);
    }

    public void deleteTitle(final Long id) {
        repository.deleteById(id);
    }
}
