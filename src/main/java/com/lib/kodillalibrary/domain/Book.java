package com.lib.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="title_id")
    @JsonBackReference
    private Long titleId;

    @Column(name = "status")
    private String status;

    @OneToOne(mappedBy = "book")
    @JsonBackReference
    private LendStatus lendStatus;

}
