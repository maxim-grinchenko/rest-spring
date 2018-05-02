package com.java.courses.resttraining.controller;

import com.java.courses.resttraining.domain.Book;
import com.java.courses.resttraining.infra.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/util")
@Slf4j
public class UtilController {
    @GetMapping("/current/date")
    public LocalDate getCurrentDate(@RequestHeader(required = false, value = "session_id") String sessionId) {
        LOGGER.info("session id: {}", sessionId);
        return LocalDate.now();
    }

    @GetMapping("current/time")
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    @GetMapping("/entity")
    public ResponseEntity responseEntity() {
        if (true) {
            throw new ValidationException("Some validation problem!");
            //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation failed!");
        }

        return ResponseEntity.ok(new Book());
    }

    /*@GetMapping(value = "find/by/id/{id}", produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE
    })
    public Book getById(@PathVariable long id) {
        LOGGER.info("id: {}", id);
        return new Book(1, "some name", "some author");
    }*/
}