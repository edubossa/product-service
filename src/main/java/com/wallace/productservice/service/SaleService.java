package com.wallace.productservice.service;

import com.wallace.productservice.converter.SaleSummaryConverter;
import com.wallace.productservice.converter.UserSummaryConverter;
import com.wallace.productservice.dto.SaleDto;
import com.wallace.productservice.dto.SaleSummaryDto;
import com.wallace.productservice.dto.UserSummaryDto;
import com.wallace.productservice.exception.NotFoundException;
import com.wallace.productservice.model.MostSoldProduct;
import com.wallace.productservice.repository.SaleRepository;
import com.wallace.productservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final UserRepository userRepository;

    public UserSummaryDto aggregateUserSummary(Long userId) {
        return userRepository.findById(userId)
                .map(u -> {
                    List<SaleSummaryDto> sales = saleRepository.findTop5ByUserIdOrderBySaleDateTimeDesc(u.getId())
                            .stream().map(s -> SaleSummaryConverter.of().convert(s))
                            .collect(Collectors.toList());
                    return UserSummaryConverter.of(sales).convert(u);
                })
                .orElseThrow(() -> new NotFoundException("User not found by id: " + userId));
    }

    public MostSoldProduct aggregateTopProductFromUserCity(SaleDto saleDto) {
        return saleRepository.findTop1ProductByUserCityId(saleDto.getCityId());
    }
}
