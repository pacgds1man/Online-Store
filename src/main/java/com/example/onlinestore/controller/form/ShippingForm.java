package com.example.onlinestore.controller.form;

import com.example.onlinestore.entity.Shipping;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ShippingForm {
    private Long id;
    @NotNull
    private Shipping.Status status;
    @NotNull
    private Long orderId;

}