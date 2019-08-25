package com.lib.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
//@AllArgsConstructor
@NoArgsConstructor
public class BookTitleDto {
    private Long id;
    private String title;
    private String author;
    private Long year;
    private List<BookDto> books;

    public BookTitleDto(Long id, String title, String author, Long year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
