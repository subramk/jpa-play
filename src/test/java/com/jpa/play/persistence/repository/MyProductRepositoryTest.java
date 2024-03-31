package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyProduct;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;
import java.util.random.RandomGenerator;

import static java.lang.Long.valueOf;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@Sql("classpath:/scripts/INIT_PRODUCTS.sql")
public class MyProductRepositoryTest extends AbstractBaseTestContainer {

    @Autowired
    private MyProductRepository myProductRepository;

    @BeforeAll
    public static void setupDb(){
        System.out.println(" Setup DB has been run");
    }


    @Order(0)
    @Test
    void saveAndRetrieveProduct() {
        int id = RandomGenerator.getDefault().nextInt();
        MyProduct bat = new MyProduct(valueOf(id),"cricket bat", BigDecimal.valueOf(35.00));

        MyProduct savedBat = myProductRepository.saveAndFlush(bat);

        assertAll(
                () -> assertNotNull(savedBat.getId()),
                () -> assertEquals(7, myProductRepository.count())
        );
  }

    @Test
    @Order(3)
    void findOneProduct() {
        List<MyProduct>  theProduct = myProductRepository.findAllByPriceGreaterThanEqual(BigDecimal.valueOf(3500L));
        assertEquals(1, theProduct.size()) ;
    }

    @Test
    @Order(4)
    void deleteAllInBatch() {

            int id = RandomGenerator.getDefault().nextInt();
            MyProduct bat1 = new MyProduct(valueOf(id),"cricket bat", BigDecimal.valueOf(85.00));
            MyProduct bat2 = new MyProduct(valueOf(id),"tennis Racquet", BigDecimal.valueOf(65.00));
            MyProduct bat3= new MyProduct(valueOf(id),"SkipRope", BigDecimal.valueOf(5.00));

            var products  = List.of(bat1,bat2,bat3);
            List<MyProduct> persistedProducts  = myProductRepository.saveAllAndFlush(products);

        assertEquals( 9,  myProductRepository.findAll().size());
        myProductRepository.deleteAllInBatch();
        assertEquals(0, myProductRepository.count());
    }

    @Test
    @Order(5)
        void deleteAllProducts() {
        myProductRepository.deleteAll();
        assertEquals(0, myProductRepository.count());
    }
}
