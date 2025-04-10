package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Integer locationId;
    @Column(name ="street_address", length = 40)
    private String streetAddress;
    @Column(name ="postal_code", length = 12)
    private String postalCode;
    @Column(name ="city", length = 30, nullable = false)
    private String city;
    @Column(name ="state_province", length = 25)
    private String stateProvince;
    @Column(name ="country_id", length = 2)
    private String countryId;

}

