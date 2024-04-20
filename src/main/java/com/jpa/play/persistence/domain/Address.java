package com.jpa.play.persistence.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity(name="address")
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
    @JoinColumn(name="custId") // cust_id column in the Address Table references the custId column in the Customer Table.
    private Customer customer;

//    @Embedded
//    @Column(name="addrType")
//    @Nullable
//    private AddressType addressType;

}
