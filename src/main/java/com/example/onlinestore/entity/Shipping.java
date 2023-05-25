package com.example.onlinestore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
    private Order order;

    @Column(name = "order_id")
    private Long orderId;

    public Shipping(Long id, Status status, Long orderId) {
        this.id = id;
        this.status = status;
        this.orderId = orderId;
    }

    public static enum Status {
        PENDING, DELIVERED, ASSEMBLY
    }
}