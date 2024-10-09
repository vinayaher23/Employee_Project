package com.example.Employee.Service;

import com.example.Employee.Entity.EmployeEntity;
import com.example.Employee.Repository.EmployeRepo;
import com.example.Employee.Repository.EmployeeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepo employeeRepo;

    public EmployeEntity addEmployee(EmployeEntity studentEntity) {

        return employeeRepo.save(studentEntity);

    }

    public List<EmployeEntity> getEmployeeAll() {

        List<EmployeEntity>  employeEntities = employeeRepo.findAll();

        return employeEntities;


    }

    public EmployeEntity getEmployeeById(Long id) {

        Optional<EmployeEntity> employe = employeeRepo.findById(id);
        if(employe.isPresent()){
            return employe.get();
        }else{

            throw new EmployeeNotFound("Employee Data Not found for id " +id);
        }
    }

    public EmployeEntity updateEmployeeById(Long id, EmployeEntity employeesdetails) {

        EmployeEntity exsistingEmployee = employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFound("Employee Not found by id"+id));
        exsistingEmployee .setId(employeesdetails.getId());
        exsistingEmployee.setName(employeesdetails.getName());
        exsistingEmployee.setDepartment(employeesdetails.getDepartment());
        exsistingEmployee.setPosition(employeesdetails.getPosition());
        exsistingEmployee.setSalary(employeesdetails.getSalary());

        return employeeRepo.save(exsistingEmployee);
    }

    public void deleteEmployee(Long id) {

        Optional<EmployeEntity> employeEntity = employeeRepo.findById(id);
        employeeRepo.deleteById(id);
    }
}
