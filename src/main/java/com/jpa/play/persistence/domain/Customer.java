package com.jpa.play.persistence.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="custId")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="gender")
    private String gender;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer" , cascade = CascadeType.ALL)
    // @JoinColumn(name ="addressId",referencedColumnName = "addressId")
    private List<Address> addresses;


}
