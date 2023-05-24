package com.example.onlinestore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status status;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Shipping(Long id, Status status, Order orderId) {
        this.id = id;
        this.status = status;
        this.order = orderId;
    }

    public static enum Status {
        PENDING, DELIVERED, ASSEMBLY
    }
}