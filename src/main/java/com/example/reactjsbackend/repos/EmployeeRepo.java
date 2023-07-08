package com.example.reactjsbackend.repos;

import com.example.reactjsbackend.entites.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {
}
