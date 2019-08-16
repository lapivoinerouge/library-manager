package com.lib.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate signUpDate;

}
