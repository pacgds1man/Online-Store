package com.example.onlinestore.controller;

import com.example.onlinestore.controller.form.ShippingForm;
import com.example.onlinestore.entity.Shipping;
import com.example.onlinestore.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shippings")
public class ShippingController {
    private ShippingRepository shippingRepo;

    @Autowired
    public ShippingController(ShippingRepository shippingRepo) {
        this.shippingRepo = shippingRepo;
    }

    @GetMapping
    public List<Shipping> findAllShipping() {
        return shippingRepo.findAll();
    }

    @GetMapping("/{id}")
    private Shipping findById(@PathVariable Long id) {
        return shippingRepo.findById(id).get();

    }

    @RolesAllowed("ADMIN")
    @PostMapping
    public Shipping newShipping(@RequestBody @Valid ShippingForm shippingForm) {
        return shippingRepo.save(toShipping(shippingForm));
    }

    @RolesAllowed("ADMIN")
    @PatchMapping("/{id}")
    public Shipping patchShipping(@PathVariable Long id, @RequestBody ShippingForm shippingForm) {
        Shipping shipping = shippingRepo.findById(id).get();

        if (shipping.getStatus() != Shipping.Status.ASSEMBLY) {
            throw new IllegalStateException("Изменить Доставку в статусе " +
                    shipping.getStatus().toString() + " невозможно");
        }

        Shipping patch = toShipping(shippingForm);
        if (patch.getOrderId() != null) {
            shipping.setOrderId(patch.getOrderId());
        }
        if (patch.getStatus() != null) {
            shipping.setStatus(patch.getStatus());
        }
        return shippingRepo.save(shipping);
    }

    private Shipping toShipping(ShippingForm shippingForm) {
        return new Shipping(shippingForm.getId(), shippingForm.getStatus(), shippingForm.getOrderId());
    }
}

