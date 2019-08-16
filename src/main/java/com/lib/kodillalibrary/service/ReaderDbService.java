package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.Reader;
import com.lib.kodillalibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderDbService {

    @Autowired
    ReaderRepository repository;

    public List<Reader> getAllReaders() {
        return repository.findAll();
    }
}
