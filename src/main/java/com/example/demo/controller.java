package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {

    private List<Book> books;

    private BookService bookService;

    public controller(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAutor) {
        return bookService.getBooks(bookAutor);
    }
    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId) {
        return this.books.get(bookId);
    }


}

