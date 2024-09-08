package com.example.spring_security_inmemory_test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.spring_security_inmemory_test.entity.Employee;
import com.example.spring_security_inmemory_test.service.EmployeeService;
import com.example.spring_security_inmemory_test.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEployeeById(@PathVariable(name = "id") int employeeId) {
        return employeeService.findEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


}
