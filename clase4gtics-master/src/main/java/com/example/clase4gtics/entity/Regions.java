package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jobs")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", precision = 22, scale = 0)
    private Integer regionId;
    @Column(name ="region_name", length = 25)
    private String jobTitle;


}

