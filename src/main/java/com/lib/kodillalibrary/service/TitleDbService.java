package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.BookTitle;
import com.lib.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleDbService {

    @Autowired
    private TitleRepository repository;

    public List<BookTitle> getAllTitles() {
        return repository.findAll();
    }
}
