package com.wallace.productservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_SALE")
public class SaleModel implements Serializable {
    private static final long serialVersionUID = 7732712828780893362L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "SALE_VALUE")
    private BigDecimal value;
    @Column(name = "PAYMENT_METHOD")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "SALE_DATE_TIME")
    private LocalDateTime saleDateTime = LocalDateTime.now();

    @ManyToOne
    private ProductModel product;
    @ManyToOne
    private UserModel user;

}
