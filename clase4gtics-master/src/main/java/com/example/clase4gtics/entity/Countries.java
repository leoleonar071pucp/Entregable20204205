package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jobs")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", length = 2)
    private Integer countryId;
    @Column(name ="country_name", length = 40)
    private String countryName;
    @Column(name ="region_id", precision = 22, scale = 0)
    private Integer regionId;

}

