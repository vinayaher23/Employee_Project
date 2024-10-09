package com.example.Employee.Entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;



    @OneToMany(mappedBy = "department")
    private Set<EmployeEntity> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Set<EmployeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeEntity> employees) {
        this.employees = employees;
    }

}


