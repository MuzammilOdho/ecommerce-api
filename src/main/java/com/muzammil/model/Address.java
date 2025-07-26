package com.muzammil.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "street_address", nullable = false)
    private String streetAddress;
    @Column(name = "city", nullable = false )
    private String city;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "country" , nullable = false)
    private String country;
    @Column(name = "zip_code")
    private String zipCode;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "address_types", joinColumns = @JoinColumn(name = "address_id"))
    @Column(name = "type")
    private Set<AddressType> types = new HashSet<AddressType>();
    @ManyToOne
    @JoinColumn(name = "address_id" , nullable = false)
    private User user;

    public Address() {
    }
}
