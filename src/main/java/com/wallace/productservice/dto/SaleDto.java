package com.wallace.productservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDto {

    private String cpf;
    private Long productId;
    private Long quantity;
    private BigDecimal value;
    private Long cityId;
    private Long stateId;
}
