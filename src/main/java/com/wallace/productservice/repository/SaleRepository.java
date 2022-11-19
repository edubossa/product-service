package com.wallace.productservice.repository;

import com.wallace.productservice.model.MostSoldProduct;
import com.wallace.productservice.model.SaleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleRepository extends CrudRepository<SaleModel, Long> {
    @Query(value = "SELECT SUM(A.QUANTITY) AS soldQuantity, A.PRODUCT_ID AS productId, C.NAME AS productName FROM TB_SALE A, TB_USER B, TB_PRODUCT C " +
            "WHERE A.USER_ID = B.ID " +
            "AND A.PRODUCT_ID = C.ID " +
            "AND B.CITY_ID = ? " +
            "GROUP BY B.CITY_ID, A.PRODUCT_ID ORDER BY soldQuantity DESC LIMIT 1", nativeQuery = true)
    MostSoldProduct findTop1ProductByUserCityId(Long cityId);

    List<SaleModel> findTop5ByUserIdOrderBySaleDateTimeDesc(Long userId);
}
