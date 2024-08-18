package com.feanix.system.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductDTO {
    private String productName;
    private int qtyOnHand;
    private double unitPrice;
}
