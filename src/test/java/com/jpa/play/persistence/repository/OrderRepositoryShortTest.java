package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.Assert.assertEquals;

@DataJpaTest
 public class OrderRepositoryShortTest extends AbstractBaseTestContainer {

        @Autowired
        private OrderRepository orderRepository;

        @BeforeAll
        static  void setUpDB(){

        }
        @Test
        @Sql("classpath:/scripts/INIT_THREE_ORDERS.sql")
        void shouldReturnOrdersThatContainMacBookPro() {
            List<Order> orders = orderRepository.findOrderWithKindle();
            assertEquals(1, orders.size());
        }
    }


