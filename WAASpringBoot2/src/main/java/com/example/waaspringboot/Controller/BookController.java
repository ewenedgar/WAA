package com.example.waaspringboot.Controller;

import com.example.waaspringboot.Model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    Book book1 = new Book(1,"book1", "1111");
    Book book2 = new Book(2,"book2", "1112");
    Book book3 = new Book(3,"book3", "1113");
    Book book4 = new Book(4,"book4", "1114");
    Book book5 = new Book(5,"book5", "1115");
    Book book6 = new Book(6,"book6", "1116");
    Book book7 = new Book(7,"book7", "1117");
    List<Book> books = new ArrayList<>();

    @GetMapping(path = "/all")
    public List<Book> getAllBooks(Book book){

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        return books;
    }
    @GetMapping(path = "/id/{id}")
    public Book getBookById(@PathVariable int id){
        for (Book b : books) {
            if(id == b.getId() ) return b;
        }
        return null;
    }
    @GetMapping(path = "/id/{id}/titles/{title}")
    public Book getBookByIdAndTitle(@PathVariable int id, @PathVariable String title){
        for (Book b : books) {
            if(b.getId() == id || b.getTitle().equals(title) ) return b;
        }
        return null;
    }
    @GetMapping(path = "/titles")
    public Book getBookByTitle( @RequestParam String title){
        for (Book b : books) {
            if(b.getTitle().equals(title) ) return b;
        }
        return new Book();
    }
}
