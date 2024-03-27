package com.jpa.play.persistence.repository;

import com.jpa.play.persistence.domain.MyProduct;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyProductTest extends AbstractBaseTestContainer {

    @Autowired
    private Validator validator;

    @Test
    void validProduct() {
        MyProduct product = new MyProduct("TV tray", BigDecimal.valueOf(10.0));
        var violations = validator.validate(product);
        assertTrue(violations.isEmpty());
    }

    @Test
    void invalidProduct() {
        MyProduct product = new MyProduct("  ", BigDecimal.valueOf(-10.0));
        var violations = validator.validate(product);
        assertEquals(2, violations.size());
        violations.forEach(System.out::println);
    }
}
