package com.example.Employee.Controller;

import com.example.Employee.Entity.EmployeEntity;
import com.example.Employee.Repository.EmployeeNotFound;
import com.example.Employee.Service.EmployeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/employees")
    public EmployeEntity addEmployee(@Valid @RequestBody EmployeEntity employeEntity) throws Exception{

        return employeService.addEmployee(employeEntity);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeEntity>> getAllStudent() {

        List<EmployeEntity> students = employeService.getEmployeeAll();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeEntity> getEmployeeById(@PathVariable Long id) {

        try {
            EmployeEntity student = employeService.getEmployeeById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (EmployeeNotFound e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeEntity employeesdetails){

        try{
            EmployeEntity updatedEmployee = employeService.updateEmployeeById(id, employeesdetails);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        }catch (EmployeeNotFound e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployeebyId(@PathVariable Long id){

        try{
             employeService.deleteEmployee(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }catch(EmployeeNotFound e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

