package com.lib.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookTitleDto {
    private Long id;
    private String title;
    private String author;
    private Long year;
    private List<BookDto> bookDtos;
}
