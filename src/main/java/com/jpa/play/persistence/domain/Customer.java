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

@Entity(name="customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="custId")
    private Long id;
    private String name;
    private String email;
    private String gender;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Address> addresses;


}
