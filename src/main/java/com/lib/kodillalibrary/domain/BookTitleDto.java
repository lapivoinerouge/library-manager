package com.lib.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookTitleDto {
    private Long id;
    private String title;
    private String author;
    private Long year;
}
