package com.wallace.productservice.helper;
import java.math.BigDecimal;

import com.wallace.productservice.dto.SaleDto;
import com.wallace.productservice.model.*;

import java.time.LocalDateTime;

import java.util.List;

public class SaleHelper {
    public static List<SaleModel> get() {
        SaleModel saleModel = new SaleModel();
        saleModel.setId(0L);
        saleModel.setQuantity(0);
        saleModel.setValue(new BigDecimal("0"));
        saleModel.setPaymentMethod(PaymentMethod.CREDIT);
        saleModel.setSaleDateTime(LocalDateTime.now());
        saleModel.setProduct(new ProductModel());
        saleModel.setUser(new UserModel());


        return List.of(saleModel);
    }


    public static MostSoldProduct getMostSoldProduct() {
        MostSoldProductImpl mostSoldProduct = new MostSoldProductImpl();
        mostSoldProduct.setSoldQuantity(0L);
        mostSoldProduct.setProductId(0L);
        mostSoldProduct.setProductName("");

        return mostSoldProduct;
    }

    public static SaleDto getSaleDto() {
        SaleDto saleDto = new SaleDto();
        saleDto.setCpf("");
        saleDto.setProductId(0L);
        saleDto.setQuantity(0L);
        saleDto.setValue(new BigDecimal("0"));
        saleDto.setCityId(1L);
        saleDto.setStateId(0L);
        return saleDto;
    }
}
