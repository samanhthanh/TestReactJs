package com.example.reactjsbackend.services;

import com.example.reactjsbackend.entites.EmployeeEntity;
import com.example.reactjsbackend.repos.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeServices {
    private final EmployeeRepo employeeRepo;

    public EmployeeImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<EmployeeEntity> getList() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeEntity getById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public EmployeeEntity edit(EmployeeEntity employeeEntity, Long id) {
        EmployeeEntity entity = employeeRepo.findById(id).orElse(null);
        try {
            if (entity != null) {
                entity.setEmailId(employeeEntity.getEmailId());
                entity.setFirstName(employeeEntity.getFirstName());
                entity.setLastName(employeeEntity.getLastName());
                return employeeRepo.save(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        EmployeeEntity entity = employeeRepo.findById(id).orElse(null);
        try {
            if (entity != null) {
                employeeRepo.delete(entity);
                return " success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
