package com.lib.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="lend_status")
public class LendStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "reader_id")
    private Long readerId;

    @Column(name = "lend_date")
    private LocalDate lendDate;

    @Column(name = "return_date")
    private LocalDate returnDate;
}
