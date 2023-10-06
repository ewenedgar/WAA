package com.example.bookstore.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class Book {
    int Id;
    String title;
    String isbn;
    double price;
}
