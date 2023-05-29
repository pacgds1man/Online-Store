package com.example.onlinestore.controller;

import com.example.onlinestore.entity.Customer;
import com.example.onlinestore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @PutMapping("/{id}")
    public Customer change(@PathVariable Long id, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer.setId(id);
        }
        return customerRepo.save(customer);
    }

    @PatchMapping("/{id}")
    public Customer patch(@PathVariable Long id, @RequestBody Customer patch) {
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
    public void delete(@PathVariable Long id) {
        customerRepo.deleteById(id);
    }
}
