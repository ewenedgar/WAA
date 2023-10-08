package edu.miu.cs.lab04.models.Q3;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float gpa;
    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}
