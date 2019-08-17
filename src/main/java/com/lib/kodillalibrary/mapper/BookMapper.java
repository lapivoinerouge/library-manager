package com.lib.kodillalibrary.mapper;

import com.lib.kodillalibrary.domain.Book;
import com.lib.kodillalibrary.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitleId(),
                bookDto.getStatus(),
                bookDto.getLendStatus());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitleId(),
                book.getStatus(),
                book.getLendStatus());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books) {
        return books.stream()
                .map(b -> new BookDto(b.getId(), b.getTitleId(), b.getStatus()))
                .collect(Collectors.toList());
    }


}
