package com.example.onlinestore.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private Integer amount;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(Long id, String item, Integer amount, Customer customer) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.customer = customer;
    }
}
