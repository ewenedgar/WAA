package edu.miu.cs.lab05.models.Q1a;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<Orderline> orderLines;
}
