package com.wallace.productservice.dto;

import com.wallace.productservice.model.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleSummaryDto {

    private Long productId;
    private String productName;
    private BigDecimal value;
    private PaymentMethod paymentMethod;

}
