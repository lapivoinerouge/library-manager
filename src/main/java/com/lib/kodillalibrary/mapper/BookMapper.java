package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.Book;
import com.lib.kodillalibrary.domain.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    private TitleMapper titleMapper;

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                titleMapper.mapToTitle(bookDto.getBookTitle()),
                bookDto.getStatus());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                titleMapper.mapToTitleDto(book.getBookTitle()),
                book.getStatus());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(b -> new BookDto(b.getId(), titleMapper.mapToTitleDto(b.getBookTitle()), b.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Book> mapToBookList(final List<BookDto> bookDtoList) {
        return bookDtoList.stream()
                .map(b -> new Book(b.getId(), titleMapper.mapToTitle(b.getBookTitle()), b.getStatus()))
                .collect(Collectors.toList());
    }
}
