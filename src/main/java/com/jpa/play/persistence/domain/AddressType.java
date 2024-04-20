package com.jpa.play.persistence.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public enum AddressType {
    HOME(1),OFFICE(2),OVERSEAS(3);
    private final int code ;
      AddressType(int code){
        this.code = code;
    };



}
