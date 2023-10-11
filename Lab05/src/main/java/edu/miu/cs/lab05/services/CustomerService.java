package edu.miu.cs.lab05.services;

import edu.miu.cs.lab05.models.Q1a.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    void save(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
}
