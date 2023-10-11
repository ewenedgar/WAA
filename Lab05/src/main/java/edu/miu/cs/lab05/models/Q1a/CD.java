package edu.miu.cs.lab05.models.Q1a;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("CD")
@Data
public class CD extends Product {
//    @Id
//    @GeneratedValue
//    privateate int id;
    private String artist;
}
