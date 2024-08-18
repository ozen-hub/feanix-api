package com.feanix.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @Column(name="payment_id", length = 80)
    private String paymentId;
    @Column(name="is_paid", columnDefinition = "TINYINT")
    private boolean isPaid;

    @OneToOne
    private CustomerOrder customerOrder;
}
