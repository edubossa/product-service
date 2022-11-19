package com.wallace.productservice.model;

public class MostSoldProductImpl implements  MostSoldProduct {

    private Long soldQuantity;
    private Long productId;
    private String productName;

    @Override
    public Long getSoldQuantity() {
        return this.soldQuantity;
    }

    @Override
    public Long getProductId() {
        return this.productId;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
