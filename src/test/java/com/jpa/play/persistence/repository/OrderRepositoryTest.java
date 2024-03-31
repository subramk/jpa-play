package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.assertEquals;


@DataJpaTest
public class OrderRepositoryTest extends  AbstractBaseTestContainer {

    @Autowired
    private OrderRepository orderRepository;

    @BeforeEach
     public void setupData(){
        System.out.println(" ..... |||||||       populating the Orders in the Database |||||||");
        System.out.println(" ..... |||||||       populating the Orders in the Database |||||||");

        orderRepository.saveAndFlush(
                createOrder(
                        "43",
                        """
                     [{"name": "Kindle", "amount" : 13}, {"name": "MacBook Pro", "amount" : 10}]
                  """));

        orderRepository.saveAndFlush(
                createOrder(
                        "42",
                        """
                     [{"name": "MacBook Pro", "amount" : 42}, {"name": "iPhone Pro", "amount" : 42}]
                  """));

        orderRepository.saveAndFlush(
                createOrder(
                        "100",
                        """
                     [{"name": "Dell laptop", "amount" : 22}, {"name": "Dell Pro", "amount" : 22}]
                  """));

        orderRepository.saveAndFlush(createOrder("44", "[]"));


    }
    @Test
    void shouldReturnOrdersThatContainKindle() {

        List<Order> totalOrdersInDatabase  = orderRepository.findAll();
        System.out.println(" ..... |||||||       Total Orders in the DB  |||||||..."  +  totalOrdersInDatabase.size());

        assertEquals(4, totalOrdersInDatabase.size());

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
