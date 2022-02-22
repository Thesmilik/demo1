package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {

    private List<Book> books;

    private BookService bookService;

    public controller(BookService bookService){
        this.books = init();
        this.bookService = bookService;
    }

    public List<Book> init( ){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setAutors("Jozo");
        book1.setTitle("Ahoj");
        books.add(book1);

        Book book2 = new Book();
        book2.setAutors("Fero");
        book2.setTitle("serus moj");
        books.add(book2);

        return books;

    }
    public List<Book> getBooks(String bookAutor) {

         List<Book> filteredBooks = new ArrayList<>();

         for(Book book : books){
             if (book.getAutors().equals(bookAutor)){
                 filteredBooks.add(book);
             }
         }

         return this.books;
    }

    public Book getBook(Integer bookId) {
        return this.books.get(bookId);
    }
}

