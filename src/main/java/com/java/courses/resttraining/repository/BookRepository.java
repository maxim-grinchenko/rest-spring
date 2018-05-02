package com.java.courses.resttraining.repository;

import com.java.courses.resttraining.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    List<Book> findAllByAuthor(String author);

}