package com.jpa.play.persistence.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "orders")
// Hibernate 5: @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Order {

    public Order() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name = "TRACKING_NUMBER")
    private String trackingNumber;

    // Hibernate 5 @Type(type = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String items;



}
