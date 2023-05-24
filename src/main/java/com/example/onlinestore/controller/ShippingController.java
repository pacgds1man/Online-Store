package com.example.onlinestore.controller;

import com.example.onlinestore.controller.form.ShippingForm;
import com.example.onlinestore.entity.Order;
import com.example.onlinestore.entity.Shipping;
import com.example.onlinestore.repository.OrderRepository;
import com.example.onlinestore.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/shippings")
public class ShippingController {
    private ShippingRepository shippingRepo;
    private OrderRepository orderRepo;

    @Autowired
    public ShippingController(ShippingRepository shippingRepo, OrderRepository orderRepo) {
        this.shippingRepo = shippingRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public List<Shipping> findAllShipping() {
        return shippingRepo.findAll();
    }

    @GetMapping("/{id}")
    private Shipping findById(@PathVariable Long id) {
        return shippingRepo.findById(id).get();

    }

    @PostMapping
    public Shipping newShipping(@RequestBody ShippingForm shippingForm) {
        return shippingRepo.save(createShipping(shippingForm));
    }

    @PatchMapping("/{id}")
    public Shipping patchShipping(@PathVariable Long id, ShippingForm shippingForm) {
        Shipping shipping = shippingRepo.findById(id).get();
        Shipping patch = createShipping(shippingForm);
        if (patch.getOrder() != null) {
            shipping.setOrder(patch.getOrder());
        }
        if (patch.getStatus() != null) {
            shipping.setStatus(patch.getStatus());
        }
        return shipping;
    }

    private Shipping createShipping(ShippingForm shippingForm) {
        Order fullOrder = orderRepo.findById(shippingForm.getOrderId())
                .orElseThrow(() -> new NoSuchElementException("no such order found"));
        return new Shipping(shippingForm.getId(), shippingForm.getStatus(), fullOrder);
    }
}

