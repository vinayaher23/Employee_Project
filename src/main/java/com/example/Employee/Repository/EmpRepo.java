package com.example.Employee.Repository;

import com.example.Employee.Entity.Employe1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employe1, Long> {
}
