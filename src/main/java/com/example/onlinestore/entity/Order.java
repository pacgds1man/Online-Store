package com.example.onlinestore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private Integer amount;
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    private Customer customer;
    @Column(name = "customer_id")
    private Long customerId;

    public Order(Long id, String item, Integer amount, Long customerId) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.customerId = customerId;
    }
}
