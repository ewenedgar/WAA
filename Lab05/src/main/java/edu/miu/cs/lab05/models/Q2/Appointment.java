package edu.miu.cs.lab05.models.Q2;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;
    @OneToOne
    private Patient patient;
    @Embedded
    private Payment payment;
    @OneToOne
    private Doctor doctor;
}
