package com.feanix.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name="product_id", length = 80)
    private String productId;
    @Column(name="product_name", length = 80)
    private String productName;
    @Column(name="qty_on_hand", length = 80)
    private int qtyOnHand;

    @Column(name="status", columnDefinition = "TINYINT")
    private boolean status;

    @Column(name="unit_price", length = 80)
    private double unitPrice;

    @Embedded
    private FileResource fileResource;

    @OneToMany(mappedBy = "product")
    private Set<CustomerOrder> orders = new HashSet<>();

}
