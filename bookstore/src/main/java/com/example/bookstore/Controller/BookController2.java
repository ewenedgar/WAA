package com.example.bookstore.Controller;

import com.example.bookstore.Model.Book;
import com.example.bookstore.Model.Book2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v2/book")
public class BookController2 {
    List<Book2> bookList  = new ArrayList<>();

            //(new Book(1, "HP", 888))
public void createBooks(){
    bookList.add(new Book2(1, "book1","1111", 11));
    bookList.add(new Book2(2, "book2","2111", 21));
    bookList.add(new Book2(3, "book3","3111", 31));
    bookList.add(new Book2(4, "book4","4111", 41));
    bookList.add(new Book2(5, "book5","5111", 51));
    bookList.add(new Book2(6, "book6","6111", 61));
    bookList.add(new Book2(7, "book7","7111", 71));
    bookList.add(new Book2(8, "book8","8111", 81));
}
    @GetMapping(value = "")
    public List<Book2> getAllBooks(){
        if(bookList.isEmpty()) createBooks();
        return  bookList;
    }
    @GetMapping("/{id}")
    public Book2 getBookById(@PathVariable int id){
            Optional<Book2> bk = bookList.stream().filter(b -> b.getId() == id)
                .findFirst();
        return bk.get();
    }
    @PostMapping("/add")
    public void addBook(@RequestBody Book2 book){
        Book2 book1 = new Book2();
        book1.setId(book.getId());
        book1.setIsbn(book.getIsbn());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
    }
    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book2 book) throws Exception {
     Optional<Book2> oldBk = bookList.stream()
             .filter(bk -> bk.getId() == id)
             .findFirst();
     if(oldBk.isPresent()){
         var old = oldBk.get();
         old.setTitle(book.getTitle());
         old.setPrice(book.getPrice());
         old.setIsbn(book.getIsbn());
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
