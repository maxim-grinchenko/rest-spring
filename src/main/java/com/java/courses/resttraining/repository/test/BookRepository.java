package com.java.courses.resttraining.repository.test;

import com.java.courses.resttraining.domain.Book;

import java.util.List;

public interface BookRepository {
    Book findById(long id);

    List<Book> findAll();

    Book save(Book book);

    boolean delete(long id);

    boolean isEmpty();
}