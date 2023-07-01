package com.akanksha.springcore.autowiring.annotation;

import com.akanksha.springcore.autowiring.annotation.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {

    @Autowired
    @Qualifier("addressTemp")
    private Address address;

    public Emp(Address address) {

        System.out.println("inside emp constructor");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {

        System.out.println("inside setter of set address in emp");
        this.address = address;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "address=" + address +
                '}';
    }
}
