package com.lib.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "titles")
public class BookTitle {

    public BookTitle(Long id, String title, String author, Long year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private Long year;

    @JsonBackReference
    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "bookTitle",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();
}