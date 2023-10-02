package com.example.waaspringboot.Controller;

import com.example.waaspringboot.Model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    @GetMapping(path = "/all")
    public String getAllBooks(){
        return "hello";
    }
}
