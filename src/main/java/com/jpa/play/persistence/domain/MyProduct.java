package com.jpa.play.persistence.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@EqualsAndHashCode
@DynamicInsert  // Insert ONLY THE REQUIRED ROWS . More Performant
@DynamicUpdate  // UPDATE only the Required Rows. More Performant.

@Entity(name="MyProduct")
public class MyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @PositiveOrZero(message = "Price must be zero or greater")
    private BigDecimal price;

    public MyProduct() {}

    public MyProduct(String name, BigDecimal price) {
        this(null, name, price);
    }

    public MyProduct(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
