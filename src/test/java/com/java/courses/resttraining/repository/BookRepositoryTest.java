package com.java.courses.resttraining.repository;

import com.java.courses.resttraining.domain.Book;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    public void save() {
        Book book = createBook();
        repository.save(book);
        System.out.println(book);
    }

    @Test
    public void findAll() {
        System.out.println(repository.findAll());
    }

    private static Book createBook() {
        String name = RandomStringUtils.randomAlphanumeric(10);
        String author = RandomStringUtils.randomAlphanumeric(10);
        int year = RandomUtils.nextInt(1990, 2000);

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setYear(year);
        return book;
    }
}