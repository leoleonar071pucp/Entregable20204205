package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false, length = 10)
    private Integer jobId;
    @Column(name ="job_title", nullable = false, length = 35)
    private String jobTitle;
    @Column(name ="min_salary")
    private Integer minSalary;
    @Column(name ="max_salary")
    private Integer maxSalary;

}

