package edu.miu.cs.lab07.services;

import edu.miu.cs.lab07.models.Book;
import edu.miu.cs.lab07.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(int id, Book newBook){
        Book oldBook = getBookById(id);
        oldBook.setTitle(newBook.getTitle());
        oldBook.setAuthor(newBook.getAuthor());
        return bookRepository.save(oldBook);
    }

    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }
}
