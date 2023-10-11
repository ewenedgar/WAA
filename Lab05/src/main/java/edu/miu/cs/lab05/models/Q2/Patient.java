package edu.miu.cs.lab05.models.Q2;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@SecondaryTable(name = "address")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(table = "address")
    private String street;
    @Column(table = "address")
    private String zip;
    @Column(table = "address")
    private String city;
}
