package com.example.clase4gtics.repository;

import com.example.clase4gtics.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

    @Query("""
        SELECT jh FROM JobHistory jh
        JOIN jh.employee e
        JOIN jh.job j
        JOIN jh.department d
        WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :searchText, '%'))
           OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :searchText, '%'))
           OR LOWER(j.jobTitle) LIKE LOWER(CONCAT('%', :searchText, '%'))
           OR LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :searchText, '%'))
    """)
    List<JobHistory> buscarPorNombreApellidoPuestoDepartamento(String searchText);
}
