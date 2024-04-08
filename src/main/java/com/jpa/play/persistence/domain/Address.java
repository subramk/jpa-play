package com.jpa.play.persistence.domain;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name="addressId")
    private Long addressId;

    private String line1;
    private String line2;
    private String line3;
    private String postCode;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="custId") // this is the ID on the 'One' side of the relationship.
    private Customer customer;

}
