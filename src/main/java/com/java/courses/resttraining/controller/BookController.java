package com.java.courses.resttraining.controller;

import com.java.courses.resttraining.domain.Book;
import com.java.courses.resttraining.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Slf4j
@RequestMapping("/book")
@RequiredArgsConstructor
//@EnableCaching
public class BookController {
    private final BookRepository repository;

    @PostMapping("/create")
    public Book create(@Valid @RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("find/by/{id}")
   // @Cacheable("book")
    public Book findById(@PathVariable long id) {
        return repository.findById(id).orElse(new Book());
    }

    @GetMapping("/find/all")
    @Cacheable("book")
    public List<Book> findAll() {
        return repository.findAll();
    }

    @PostMapping("/update")
   // @CachePut("book")
    public void update(@Valid @RequestBody Book book) {
        repository.save(book);
    }

    @GetMapping("find/all/hateoas")
    public List<Resource<Book>> findAllHateoas(){
        List<Book> books = repository.findAll();

        List<Resource<Book>>  resources = new ArrayList<>();

        for (Book book : books){
            Resource<Book> resource = new Resource<Book>(book);
            resource.add(linkTo(methodOn(BookController.class).findById(book.getId())).withSelfRel());
            resources.add(resource);
        }

    //    return repository.findAll().stream().map(this::addLink).collect((Collectors.toList());
        return resources;
    }

    @GetMapping("/greet")
    @Cacheable("greeting")
    public String greet (){
        return "hello";
    }

    @GetMapping("/greet-nocache")
    @CachePut("greeting")
    public String greetNoCache (){
        return "hello-1";
    }

    @GetMapping("greet-clear")
    @CacheEvict(cacheNames = "greeting", allEntries = true)
    public void clearCache(){
    }




}