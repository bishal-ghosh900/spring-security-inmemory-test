package com.example.spring_security_inmemory_test.service;

import java.util.List;

import com.example.spring_security_inmemory_test.entity.Employee;


public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findEmployeeById(int id);
    public Employee addEmployee(Employee employee);
    public String deleteEmoployeeById(int id);
    public Employee updatEmployee(Employee employee);
}
