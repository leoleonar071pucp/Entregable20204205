package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Length;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "job_history")
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer departmentId;
    @Column(name ="start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name ="end_date", nullable = false)
    private LocalDateTime endDate;
    @Column(name ="job_id", length = 10, nullable = false)
    private String jobId;
    @Column(name ="department_id")
    private Integer departmentId;

}

