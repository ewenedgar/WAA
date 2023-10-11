package edu.miu.cs.lab05.models.Q2;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Payment {
    private String paydate;
    private double amount;
}
