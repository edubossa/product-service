package com.wallace.productservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSummaryDto {

    private String cpf;
    private String name;
    private String address;
    private List<SaleSummaryDto> lastOrders;


}
