package com.java.courses.resttraining.repository.test;

import com.java.courses.resttraining.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SimpleBookRepository implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    private long counter = 0;

    @Override
    public Book findById(long id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            counter++;
            book.setId(counter);
            books.put(counter, book);
            System.out.println("*** Book with id=" + book.getId() + " was created");
        } else {
            books.put(book.getId(), book);
            System.out.println("*** Book with id=" + book.getId() + " was updated");
        }
        return book;
    }

    @Override
    public boolean delete(long id) {
        if (!books.containsKey(id)) {
            return false;
        }

        books.remove(id);
        System.out.println("*** Book with id=" + id + " was deleted");
        return true;
    }

    @Override
    public boolean isEmpty() {
        return books.isEmpty();
    }
}