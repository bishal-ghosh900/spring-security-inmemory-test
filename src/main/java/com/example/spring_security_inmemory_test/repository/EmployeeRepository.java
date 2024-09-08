package com.example.spring_security_inmemory_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_security_inmemory_test.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{}
