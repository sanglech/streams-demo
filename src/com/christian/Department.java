package com.christian;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;

    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees=new ArrayList<>();
    }
    public void addEmployee(Employee emp){
        employees.add(emp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
