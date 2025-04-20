package com.example.clase4gtics.repository;


import com.example.clase4gtics.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    @Query("SELECT DISTINCT e.manager FROM Employees e WHERE e.manager IS NOT NULL")
    List<Employees> findAllManagers();

}

