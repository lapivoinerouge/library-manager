package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.Reader;
import com.lib.kodillalibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderDbService {

    @Autowired
    ReaderRepository repository;

    public List<Reader> getAllReaders() {
        return repository.findAll();
    }

    public Optional<Reader> getReader(final Long id) {
        return repository.findById(id);
    }

    public Reader saveReader(final Reader reader) {
        return repository.save(reader);
    }

    public void deleteReader(final Long id) {
        repository.deleteById(id);
    }
}
