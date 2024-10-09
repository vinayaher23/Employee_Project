package com.example.Employee.Repository;

import com.example.Employee.Entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<EmployeEntity, Long> {
}
