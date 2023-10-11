package edu.miu.cs.lab05.repository;

import edu.miu.cs.lab05.models.Q1a.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
