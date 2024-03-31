package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Order;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


//TODO Fix this test . not sure why it is failing.
class OrderRepositoryTest extends  AbstractBaseTestContainer {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
     void setupData(){
        System.out.println(" ..... |||||||       populating the Orders in the Database |||||||");
//

    }
    @Test
    @Disabled
    void shouldReturnOrdersThatContainKindle() {

        List<Order> totalOrdersInDatabase  = orderRepository.findAll();
        System.out.println(" ..... |||||||       Total Orders in the DB  |||||||..."  +  totalOrdersInDatabase.size());

        List<Order> orders = orderRepository.findOrderWithKindle();
        assertEquals(1, orders.size());
    }

    private Order createOrder(String trackingNumber, String items) {
        Order order = new Order();
        order.setTrackingNumber(trackingNumber);
        order.setItems(items);
        return order;
    }
}
