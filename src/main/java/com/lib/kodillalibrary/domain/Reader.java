package com.lib.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "readers")
public class Reader {

    public Reader(Long id, String firstname, String lastname, LocalDate signUpDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.signUpDate = signUpDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "firstname")
    @NotNull
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Column(name = "signup_date")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate signUpDate;


    @OneToMany(
            targetEntity = LendStatus.class,
            mappedBy = "readerId",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<LendStatus> lendBooks = new ArrayList<>();
}
