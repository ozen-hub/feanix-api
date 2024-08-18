package com.feanix.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "customer_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
    @Id
    @Column(name = "order_id", length = 80)
    private String orderId;
    private double total;
    private int qty;
    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SystemUser user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(mappedBy = "customerOrder")
    private Payment payment;

}
