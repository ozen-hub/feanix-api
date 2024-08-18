package com.feanix.system.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDto {
    private String productId;
    private String productName;
    private int qtyOnHand;
    private boolean status;
    private double unitPrice;
}
