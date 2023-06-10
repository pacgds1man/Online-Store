package com.example.onlinestore.controller;

import com.example.onlinestore.controller.form.OrderForm;
import com.example.onlinestore.entity.Order;
import com.example.onlinestore.repository.OrderRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@SecurityRequirement(name = "basicAuth")
public class OrderController {
    private final OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody OrderForm orderForm) {
        return orderRepo.save(toOrder(orderForm));
    }

    @PutMapping("/{id}")
    public Order change(@PathVariable Long id, @RequestBody OrderForm orderForm) {
        return orderRepo.save(toOrder(orderForm));
    }

    @PatchMapping("/{id}")
    public Order patch(@PathVariable Long id, @RequestBody OrderForm orderForm) {
        Order order = orderRepo.findById(id).get();
        Order patch = toOrder(orderForm);

        if (patch.getItem() != null) {
            order.setItem(patch.getItem());
        }
        if (patch.getAmount() != null) {
            order.setAmount(patch.getAmount());
        }
        if (patch.getCustomerId() != null) {
            order.setCustomerId(patch.getCustomerId());
        }
        return orderRepo.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderRepo.deleteById(id);
    }

    public Order toOrder(OrderForm orderForm) {
        return new Order(orderForm.getId(), orderForm.getItem(), orderForm.getAmount(), orderForm.getCustomerId());
    }

}
