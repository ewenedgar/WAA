package edu.miu.cs.lab05.models.Q1a;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@DiscriminatorValue("Book")
@Data
public class Book extends Product{
//    @Id
//    @GeneratedValue
//    private int id;
    private String title;
}
