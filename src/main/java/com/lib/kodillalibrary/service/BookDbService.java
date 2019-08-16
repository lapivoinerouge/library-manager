package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.Book;
import com.lib.kodillalibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDbService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

}
