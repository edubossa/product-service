package com.wallace.productservice.converter;

import com.wallace.productservice.dto.SaleSummaryDto;
import com.wallace.productservice.model.SaleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

@RequiredArgsConstructor(staticName = "of")
public class SaleSummaryConverter implements Converter<SaleModel, SaleSummaryDto> {

    @Override
    public SaleSummaryDto convert(SaleModel source) {
        SaleSummaryDto saleSummaryDto = new SaleSummaryDto();
        saleSummaryDto.setProductId(source.getProduct().getId());
        saleSummaryDto.setProductName(source.getProduct().getName());
        saleSummaryDto.setValue(source.getValue());
        saleSummaryDto.setPaymentMethod(source.getPaymentMethod());
        return saleSummaryDto;
    }
}
