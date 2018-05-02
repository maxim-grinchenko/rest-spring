package com.java.courses.resttraining.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @NotNull
    @NotBlank
    @Size(max = 20)

    @Column(name = "AUTHOR")
    private String author;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private int year;

//    @Column(name = "ARENDA")
//    private boolean arenda;
}
