package com.lib.kodillalibrary.controller;

import com.lib.kodillalibrary.controller.exceptions.NotFoundException;
import com.lib.kodillalibrary.domain.BookDto;
import com.lib.kodillalibrary.mapper.BookMapper;
import com.lib.kodillalibrary.service.BookDbService;
import com.lib.kodillalibrary.service.LendStatusDbService;
import com.lib.kodillalibrary.service.TitleDbService;
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

    @Autowired
    TitleDbService titleDbService;
    @Autowired
    LendStatusDbService lendStatusDbService;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(bookDbService.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long bookId) throws NotFoundException {
        return bookMapper.mapToBookDto(bookDbService.getBook(bookId).orElseThrow(()-> new NotFoundException(bookId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) throws NotFoundException {
        try {
            bookDbService.deleteBook(bookId);
        } catch (Exception e) {
            throw new NotFoundException(bookId);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "editBook")
    public void editBook(@RequestBody BookDto bookDto) throws NotFoundException {

        Long bookId = bookDto.getId();
        Long titleId = bookDto.getTitleId();

        boolean book = bookDbService.getBook(bookDto.getId()).isPresent();
        boolean title = titleDbService.getTitle(bookDto.getTitleId()).isPresent();

        if (book && title) {
            bookMapper.mapToBookDto(bookDbService.saveBook(bookMapper.mapToBook(bookDto)));
        } else {
            throw new NotFoundException(!book? bookId : titleId);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        bookDbService.saveBook(bookMapper.mapToBook(bookDto));
    }
}
