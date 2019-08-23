package com.lib.kodillalibrary.service;

import com.lib.kodillalibrary.domain.Book;
import com.lib.kodillalibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDbService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBook(final Long id) {
        return repository.findById(id);
    }

    public Book saveBook(final Book book) {
        return repository.save(book);
    }

    public void deleteBook(final Long id) {
        repository.deleteById(id);
    }
}
