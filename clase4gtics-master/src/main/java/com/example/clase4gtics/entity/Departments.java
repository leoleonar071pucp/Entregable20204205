package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private Integer departmentId;
    @Column(name ="department_name", length = 30, nullable = false)
    private String departmentName;
    @Column(name ="manager_id")
    private Integer managerId;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Locations location;


}

