package edu.miu.cs.lab07.controllers;

import edu.miu.cs.lab07.models.Book;
import edu.miu.cs.lab07.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
        return "Book with id: " + id + " - Deleted Successfully";
    }
}
