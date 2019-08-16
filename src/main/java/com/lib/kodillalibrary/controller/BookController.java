package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.domain.BookDto;
import com.lib.kodillalibrary.mapper.BookMapper;
import com.lib.kodillalibrary.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/library/books")
public class BookController {

    @Autowired
    BookDbService bookDbService;
    @Autowired
    BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(bookDbService.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(Long bookId) {
        return new BookDto(1L, 1L, "lost");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(Long bookId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "editBook")
    public BookDto editBook(BookDto bookDto) {
        return new BookDto(1L, 1L, "damaged");
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(BookDto bookDto) {

    }

}
