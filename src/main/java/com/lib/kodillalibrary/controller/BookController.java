package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.controller.exceptions.NotFoundException;
import com.lib.kodillalibrary.domain.BookDto;
import com.lib.kodillalibrary.mapper.BookMapper;
import com.lib.kodillalibrary.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BookDto getBook(@RequestParam Long bookId) throws NotFoundException {
        return bookMapper.mapToBookDto(bookDbService.getBook(bookId).orElseThrow(()-> new NotFoundException(bookId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        bookDbService.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "editBook")
    public BookDto editBook(@RequestBody BookDto bookDto) {

        return bookMapper.mapToBookDto(bookDbService.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        bookDbService.saveBook(bookMapper.mapToBook(bookDto));
    }

}
