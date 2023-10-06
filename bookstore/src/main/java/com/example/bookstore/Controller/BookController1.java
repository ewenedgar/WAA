package com.example.bookstore.Controller;

import com.example.bookstore.Model.Book;
import com.example.bookstore.Model.Book1;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/book")
public class BookController1 {
    List<Book1> bookList  = new ArrayList<>();

            //(new Book(1, "HP", 888))
public void createBooks(){
    bookList.add(new Book1(1, "book1", 11.1));
    bookList.add(new Book1(2, "book2", 21.1));
    bookList.add(new Book1(3, "book3", 31.1));
    bookList.add(new Book1(4, "book4",41.1));
    bookList.add(new Book1(5, "book5", 51.1));
    bookList.add(new Book1(6, "book6", 61.1));
    bookList.add(new Book1(7, "book7", 71.1));
    bookList.add(new Book1(8, "book8", 81.1));
}
    @GetMapping(value = "", params = "version=1")
    public List<Book1> getAllBooksV1(){
        if(bookList.isEmpty()) createBooks();
        return  bookList;
    }
    @GetMapping(value = "/produces", produces ="application/vnd.company.app-v1+json")
    public List<Book1> getAllBooksV1ByProduces(){
        if(bookList.isEmpty()) createBooks();
        return  bookList;
    }
    @GetMapping(value = "/header", headers = "X-API-VERSION=1")
    public List<Book1> getAllBooksV1ByHeaders(){
        if(bookList.isEmpty()) createBooks();
        return  bookList;
    }
    @GetMapping(value = "/params", params = "version=1")
    public List<Book1> getAllBooksV1ByParams(){
        if(bookList.isEmpty()) createBooks();
        return  bookList;
    }

    @GetMapping(value ="/{id}")
    public Book1 getBookById(@PathVariable int id){
            Optional<Book1> bk = bookList.stream().filter(b -> b.getId() == id)
                .findFirst();
        return bk.get();
    }
    @PostMapping("/add")
    public void addBook(@RequestBody Book1 book){
        Book1 book1 = new Book1();
        book1.setId(book.getId());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
    }
    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book1 book) throws Exception {
     Optional<Book1> oldBk = bookList.stream()
             .filter(bk -> bk.getId() == id)
             .findFirst();
     if(oldBk.isPresent()){
         var old = oldBk.get();
         old.setTitle(book.getTitle());
         old.setPrice(book.getPrice());
     }else{
         throw new Exception("Not found ");
     }

    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookList = bookList.stream()
                .filter(bk -> bk.getId() != id)
                .collect(Collectors.toList());
    }

}
