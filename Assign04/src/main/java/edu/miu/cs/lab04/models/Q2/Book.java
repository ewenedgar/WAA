package edu.miu.cs.lab04.models.Q2;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String isbn;
    @ManyToOne
    private Publisher publisher;
}
