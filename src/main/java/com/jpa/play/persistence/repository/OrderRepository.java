package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(
            value =
                    """
                SELECT *
                FROM orders
                WHERE items @> '[{"name": "Kindle"}]';
              """,
            nativeQuery = true)

    List<Order> findOrderWithKindle();

    List<Order> findAllByTrackingNumber(String trackingNumber);
}
