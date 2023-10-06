package com.example.bookstore.Controller;

import com.example.bookstore.Model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    List<Book> bookList  = new ArrayList<>();

            //(new Book(1, "HP", 888))
public void createBooks(){
    bookList.add(new Book(1, "book1","1111", 11.1));
    bookList.add(new Book(2, "book2","2111", 21.1));
    bookList.add(new Book(3, "book3","3111", 31.1));
    bookList.add(new Book(4, "book4","4111", 41.1));
    bookList.add(new Book(5, "book5","5111", 51.1));
    bookList.add(new Book(6, "book6","6111", 61.1));
    bookList.add(new Book(7, "book7","7111", 71.1));
    bookList.add(new Book(8, "book8","8111", 81.1));
}
    @GetMapping(value = "")
    public List<Book> getAllBooks(){
        if(bookList.isEmpty()) createBooks();
        return  bookList;
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
            Optional<Book> bk = bookList.stream().filter(b -> b.getId() == id)
                .findFirst();
        return bk.get();
    }
    @PostMapping("/add")
    public void addBook(@RequestBody Book book){
        Book book1 = new Book();
        book1.setId(book.getId());
        book1.setIsbn(book.getIsbn());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
    }
    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book) throws Exception {
     Optional<Book> oldBk = bookList.stream()
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
