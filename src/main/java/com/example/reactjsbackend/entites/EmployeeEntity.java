package com.example.reactjsbackend.entites;
import jakarta.persistence.*;
import lombok.Data;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
