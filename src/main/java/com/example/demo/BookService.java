package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books;

    private BookService bookService;

    public BookService(){
        this.books = init();
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

    @GetMapping("/api/books")
    public List<Book> getBooks(String bookAutor) {

        List<Book> filteredBooks = new ArrayList<>();

        for(Book book : books){
            if (book.getAutors().equals(bookAutor)){
                filteredBooks.add(book);
            }
        }



        return this.books;
    }
    @GetMapping("/api/books/{bookId}")
    public Book getBook(Integer bookId) {
        return this.books.get(bookId);
    }

}
