package com.lib.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LendStatusDto {
    private Long id;
    private Long bookId;
    private Long readerId;
    private LocalDate lendDate;
    private LocalDate returnDate;
}
