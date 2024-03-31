package com.jpa.play.persistence.repository;

// From
// https://github.com/rieckpil/blog-tutorials/blob/master/spring-boot-datajpatest/src/test/java/de/rieckpil/blog/OrderRepositoryShortTest.java

import com.jpa.play.persistence.domain.Order;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderRepositoryInitTest extends AbstractBaseTestContainer {

    @Autowired
    private OrderRepository orderRepository;


    @BeforeEach
    public void initData() {
        orderRepository.save(
                createOrder(
                        "42",
                        """
                     [{"name": "MacBook Pro", "amount" : 42}, {"name": "iPhone Pro", "amount" : 42}]
                  """));

        orderRepository.save(
                createOrder(
                        "43",
                        """
                     [{"name": "Kindle", "amount" : 13}, {"name": "MacBook Pro", "amount" : 10}]
                  """));

        orderRepository.save(createOrder("44", "[]"));
    }


    @Test
    void shouldReturnOrdersThatContainMacBookPro() {
        List<Order> orders = orderRepository.findOrderWithKindle();
        assertEquals(1, orders.size());
    }

    @Test
    void shouldReturnAllOrders() {
        List<Order> orders = orderRepository.findAll();
        assertEquals(3, orders.size());
    }

    private Order createOrder(String trackingNumber, String items) {
        Order order = new Order();
        order.setTrackingNumber(trackingNumber);
        order.setItems(items);
        return order;
    }

}
