package com.example.waaspringboot.Controller;

import com.example.waaspringboot.Model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    @GetMapping(path = "/all")
    public List<Book> getAllBooks(Book book){
        Book book1 = new Book(1,"book1", "1111");
        Book book2 = new Book(2,"book2", "1112");
        Book book3 = new Book(3,"book3", "1113");
        Book book4 = new Book(4,"book4", "1114");
        Book book5 = new Book(5,"book5", "1115");
        Book book6 = new Book(6,"book6", "1116");
        Book book7 = new Book(7,"book7", "1117");

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        return books;
    }
}
