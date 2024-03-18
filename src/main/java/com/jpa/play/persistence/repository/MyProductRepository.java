package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MyProductRepository extends JpaRepository<MyProduct, Long> {
    List<MyProduct> findAllByPriceGreaterThanEqual(BigDecimal minPrice);
}
