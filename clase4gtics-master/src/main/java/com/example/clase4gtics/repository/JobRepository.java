package com.example.clase4gtics.repository;


import com.example.clase4gtics.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs,String> {
}

