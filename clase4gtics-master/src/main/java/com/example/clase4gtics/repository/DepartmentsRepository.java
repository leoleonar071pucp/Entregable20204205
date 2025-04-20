package com.example.clase4gtics.repository;
import com.example.clase4gtics.entity.Departments;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends CrudRepository<Departments, Integer> {
}
