package edu.miu.cs.lab05.models.Q1a;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @OneToMany
    private List<Product> products;
}
