package edu.miu.cs.lab04.models.Q6;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNumber;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees;
}
