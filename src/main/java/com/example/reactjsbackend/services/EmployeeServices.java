package com.example.reactjsbackend.services;

import com.example.reactjsbackend.entites.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeServices {
     List<EmployeeEntity> getList();
     EmployeeEntity getById(Long id);
     EmployeeEntity save(EmployeeEntity employeeEntity);
     EmployeeEntity edit(EmployeeEntity employeeEntity, Long id);
     String delete(Long id);
}
