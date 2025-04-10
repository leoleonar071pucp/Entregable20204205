package com.example.clase4gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name ="first_name", length = 20)
    private String firstName;
    @Column(name ="last_name", length = 25, nullable = false)
    private String lastName;
    @Column(name ="email", length = 25, nullable = false)
    private String email;
    @Column(name ="phone_number", length = 20)
    private String phoneNumber;
    @Column(name ="hire_date")
    private LocalDateTime hireDate;
    @Column(name ="job_id", length = 10, nullable = false)
    private String jobId;
    @Column(name ="salary", precision = 8, scale = 2)
    private BigDecimal salary;
    @Column(name ="comission_pct", precision = 2, scale = 2)
    private BigDecimal comissionPct;
    @Column(name ="manager_id")
    private Integer managerId;
    @Column(name ="department_id")
    private Integer departmentId;


}

