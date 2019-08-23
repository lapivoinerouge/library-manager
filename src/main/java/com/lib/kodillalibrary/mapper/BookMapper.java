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
    private LendStatusMapper lendStatusMapper;

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitleId(),
                bookDto.getStatus(),
                lendStatusMapper.mapToLendStatus(bookDto.getLendStatusDto()));
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitleId(),
                book.getStatus(),
                lendStatusMapper.mapToLendStatusDto(book.getLendStatus()));
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(b -> new BookDto(b.getId(), b.getTitleId(), b.getStatus(), lendStatusMapper.mapToLendStatusDto(b.getLendStatus())))
                .collect(Collectors.toList());
    }

    public List<Book> mapToBookList(final List<BookDto> bookDtoList) {
        return bookDtoList.stream()
                .map(b -> new Book(b.getId(), b.getTitleId(), b.getStatus(), lendStatusMapper.mapToLendStatus(b.getLendStatusDto())))
                .collect(Collectors.toList());
    }
}
