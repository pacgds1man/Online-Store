package com.example.onlinestore.controller;

import com.example.onlinestore.entity.Customer;
import com.example.onlinestore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PrePersist;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepo;

    @Autowired
    public CustomerController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer newCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @PutMapping("/{id}")
    public Customer chengeCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer.setId(id);
        }
        return customerRepo.save(customer);
    }

    @PatchMapping("/{id}")
    public Customer patchCustomer(@PathVariable Long id, @RequestBody Customer patch) {
        Customer customer = customerRepo.findById(id).get();
        if (patch.getFirstname() != null) {
            customer.setFirstname(patch.getFirstname());
        }
        if (patch.getLastname() != null) {
            customer.setLastname(patch.getLastname());
        }
        if (patch.getAge() != null) {
            customer.setAge(patch.getAge());
        }
        if (patch.getCountry() != null) {
            customer.setCountry(patch.getCountry());
        }
        return customerRepo.save(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerRepo.deleteById(id);
    }
}
