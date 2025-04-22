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

    @Query("""
           SELECT e FROM Employees e
           JOIN e.job j
           JOIN e.department d
           JOIN d.location l
           WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :searchText, '%'))
              OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :searchText, '%'))
              OR LOWER(j.jobTitle) LIKE LOWER(CONCAT('%', :searchText, '%'))
              OR LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :searchText, '%'))
              OR LOWER(l.city) LIKE LOWER(CONCAT('%', :searchText, '%'))
           """)
    List<Employees> buscarPorNombreApellidoPuestoDepartamentoCiudad(String searchText);

}

