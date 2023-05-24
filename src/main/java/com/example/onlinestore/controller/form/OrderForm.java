package com.example.onlinestore.controller.form;

import lombok.Data;

@Data
public class OrderForm {
    private Long id;
    private String item;
    private Integer amount;
    private Long customerId;
}
