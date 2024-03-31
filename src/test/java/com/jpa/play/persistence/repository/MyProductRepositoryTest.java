package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyProduct;
import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import static java.lang.Long.valueOf;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class MyProductRepositoryTest  {

    @Autowired
    private MyProductRepository myProductRepository;

    @BeforeClass
    @Sql("/scripts/INIT_PRODUCTS.sql")
    public static void setupDb(){
    }

    @Test
    @Order(3)
    void countProducts() {
        assertEquals(3, myProductRepository.count());
    }

    @Test
    @Order(2)
    void findById() {
        assertTrue(myProductRepository.findById(1L).isPresent());
    }

    @Test
    @Order(1)
    void findAll() {
        List<MyProduct> products = myProductRepository.findAll();
        assertEquals(3, products.size());
    }

    @Order(0)
    void insertProduct() {
        int id = RandomGenerator.getDefault().nextInt();
        MyProduct bat = new MyProduct(valueOf(id),"cricket bat", BigDecimal.valueOf(35.00));

        MyProduct savedBat = myProductRepository.saveAndFlush(bat);

        assertAll(
                () -> assertNotNull(savedBat.getId()),
                () -> assertEquals(4, myProductRepository.count())
        );
    }

    @Test
    @Order(52)
    void deleteProduct() {
        myProductRepository.deleteById(1L);
        assertEquals(3, myProductRepository.count());
    }

    @Test
    @Order(51)
    void deleteAllInBatch() {

            int id = RandomGenerator.getDefault().nextInt();
            MyProduct bat1 = new MyProduct(valueOf(id),"cricket bat", BigDecimal.valueOf(85.00));
            MyProduct bat2 = new MyProduct(valueOf(id),"tennis Racquet", BigDecimal.valueOf(65.00));
            MyProduct bat3= new MyProduct(valueOf(id),"SkipRope", BigDecimal.valueOf(5.00));

            var products  = List.of(bat1,bat2,bat3);
            List<MyProduct> persistedProducts  = myProductRepository.saveAllAndFlush(products);

        myProductRepository.deleteAllInBatch();
        assertEquals(0, myProductRepository.count());
    }

//    @Test
//    @Order(7)
//    void deleteAllProducts() {
//        myProductRepository.deleteAll();
//        assertEquals(0, myProductRepository.count());
//    }
}
