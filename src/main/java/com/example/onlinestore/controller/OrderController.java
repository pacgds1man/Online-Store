package com.example.onlinestore.controller;

import com.example.onlinestore.controller.form.OrderForm;
import com.example.onlinestore.entity.Customer;
import com.example.onlinestore.entity.Order;
import com.example.onlinestore.repository.CustomerRepository;
import com.example.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public List<Order> findAllOrder() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return orderRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order newOrder(@RequestBody OrderForm orderForm) {
        return orderRepo.save(createOrder(orderForm));
    }

    @PutMapping("/{id}")
    public Order changeOrder(@PathVariable Long id, @RequestBody OrderForm orderForm) {
        return orderRepo.save(createOrder(orderForm));
    }

    @PatchMapping("/{id}")
    public Order patchOrder(@PathVariable Long id, @RequestBody OrderForm orderForm) {
        Order order = orderRepo.findById(id).get();
        Order patch = createOrder(orderForm);

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
    public void deleteOrder(@PathVariable Long id) {
        orderRepo.deleteById(id);
    }

    public Order createOrder(OrderForm orderForm) {
        return new Order(orderForm.getId(), orderForm.getItem(), orderForm.getAmount(), orderForm.getCustomerId());
    }

}
