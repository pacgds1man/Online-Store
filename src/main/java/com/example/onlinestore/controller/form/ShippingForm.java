package com.example.onlinestore.controller.form;

import com.example.onlinestore.entity.Shipping;
import lombok.Data;

@Data
public class ShippingForm {

    private Long id;
    private Shipping.Status status;
    private Long orderId;

}