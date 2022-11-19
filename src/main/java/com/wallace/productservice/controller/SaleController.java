package com.wallace.productservice.controller;

import com.wallace.productservice.dto.SaleDto;
import com.wallace.productservice.dto.UserSummaryDto;
import com.wallace.productservice.model.MostSoldProduct;
import com.wallace.productservice.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aggregate")
@RequiredArgsConstructor
@Slf4j
public class SaleController {

    private final SaleService service;


    @GetMapping("/user/{userId}/summary")
    public UserSummaryDto getUserSummary(@PathVariable Long userId) {
        return service.aggregateUserSummary(userId);
    }

    @PostMapping("/most-sold-product")
    public MostSoldProduct aggregateTopProductFromUserCity(@RequestBody SaleDto sale) {
        return service.aggregateTopProductFromUserCity(sale);
    }

}
