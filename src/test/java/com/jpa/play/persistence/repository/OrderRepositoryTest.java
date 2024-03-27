package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest extends  AbstractBaseTestContainer {

    @Autowired private OrderRepository orderRepository;

    @Test
    void shouldReturnOrdersThatContainMacBookPro() {

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

        List<Order> orders = orderRepository.findAllContainingMacBookPro();

        assertEquals(2, orders.size());
    }

    private Order createOrder(String trackingNumber, String items) {
        Order order = new Order();
        order.setTrackingNumber(trackingNumber);
        order.setItems(items);
        return order;
    }
}
