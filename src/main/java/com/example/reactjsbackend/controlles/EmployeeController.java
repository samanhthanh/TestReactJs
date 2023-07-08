package com.example.reactjsbackend.controlles;

import com.example.reactjsbackend.entites.EmployeeEntity;
import com.example.reactjsbackend.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/employee")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/getList")
    public List<?> getAll() {
        return employeeServices.getList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeServices.getById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeEntity employeeEntity) {
        return new ResponseEntity<>(employeeServices.save(employeeEntity),HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody EmployeeEntity employeeEntity, @PathVariable Long id) {
        return new ResponseEntity<>(employeeServices.edit(employeeEntity, id), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeServices.delete(id);
        return new ResponseEntity<>(employeeServices.delete(id),HttpStatus.OK);
    }

}
