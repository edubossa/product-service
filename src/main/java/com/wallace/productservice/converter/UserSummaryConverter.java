package com.wallace.productservice.converter;

import com.wallace.productservice.dto.SaleSummaryDto;
import com.wallace.productservice.dto.UserSummaryDto;
import com.wallace.productservice.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@RequiredArgsConstructor(staticName = "of")
public class UserSummaryConverter implements Converter<UserModel, UserSummaryDto> {

    private final List<SaleSummaryDto> lastOrders;

    @Override
    public UserSummaryDto convert(UserModel source) {
        UserSummaryDto userSummaryDto = new UserSummaryDto();
        userSummaryDto.setCpf(source.getCpf());
        userSummaryDto.setName(source.getName());
        userSummaryDto.setAddress(source.getAddress());
        userSummaryDto.setLastOrders(lastOrders);
        return userSummaryDto;
    }
}
