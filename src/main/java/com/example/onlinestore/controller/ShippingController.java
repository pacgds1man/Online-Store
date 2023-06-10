package com.example.onlinestore.controller;

import com.example.onlinestore.controller.form.ShippingForm;
import com.example.onlinestore.entity.Shipping;
import com.example.onlinestore.repository.ShippingRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")
@SecurityRequirement(name = "basicAuth")
public class ShippingController {
    private ShippingRepository shippingRepo;

    @Autowired
    public ShippingController(ShippingRepository shippingRepo) {
        this.shippingRepo = shippingRepo;
    }

    @GetMapping
    public List<Shipping> findAll() {
        return shippingRepo.findAll();
    }

    @GetMapping("/{id}")
    public Shipping findById(@PathVariable Long id) {
        return shippingRepo.findById(id).get();

    }

    @RolesAllowed("ADMIN")
    @PostMapping
    public Shipping create(@RequestBody @Valid ShippingForm shippingForm) {
        return shippingRepo.save(toShipping(shippingForm));
    }

    @RolesAllowed("ADMIN")
    @PatchMapping("/{id}")
    public Shipping patch(@PathVariable Long id, @Valid @RequestBody ShippingForm shippingForm) {
        Shipping shipping = shippingRepo.findById(id).get();

        if (shipping.getStatus() != Shipping.Status.ASSEMBLY) {
            throw new IllegalStateException("Изменить Доставку в статусе " +
                    shipping.getStatus().toString() + " невозможно");
        }

        Shipping patch = toShipping(shippingForm);
            shipping.setOrderId(patch.getOrderId());
            shipping.setStatus(patch.getStatus());
        return shippingRepo.save(shipping);
    }

    private Shipping toShipping(ShippingForm shippingForm) {
        return new Shipping(shippingForm.getId(), shippingForm.getStatus(), shippingForm.getOrderId());
    }
}

