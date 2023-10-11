package edu.miu.cs.lab05.controllers;

import edu.miu.cs.lab05.models.Q1a.Customer;
import edu.miu.cs.lab05.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public String createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return "Cusomter Saved";
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
}
