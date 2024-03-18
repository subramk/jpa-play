package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyProduct;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import static java.lang.Long.valueOf;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MyProductRepositoryTest {
    @Autowired
    private MyProductRepository myProductRepository;

    @Test
    void countProducts() {
        assertEquals(3, myProductRepository.count());
    }

    @Test
    void findById() {
        assertTrue(myProductRepository.findById(1L).isPresent());
    }

    @Test
    void findAll() {
        List<MyProduct> products = myProductRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
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
    void deleteProduct() {
        myProductRepository.deleteById(1L);
        assertEquals(2, myProductRepository.count());
    }

    @Test
    void deleteAllInBatch() {
        myProductRepository.deleteAllInBatch();
        assertEquals(0, myProductRepository.count());
    }

    @Test
    void deleteAllProducts() {
        myProductRepository.deleteAll();
        assertEquals(0, myProductRepository.count());
    }
}
