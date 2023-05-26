package com.example.onlinestore.controller.form;

import com.example.onlinestore.entity.Shipping;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ShippingForm {
    private Long id;
    @NotNull
    private Shipping.Status status;
    @NotNull
    private Long orderId;

}