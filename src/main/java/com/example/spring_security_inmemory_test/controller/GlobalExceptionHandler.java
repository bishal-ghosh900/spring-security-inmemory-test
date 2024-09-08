package com.example.spring_security_inmemory_test.controller;

import com.example.spring_security_inmemory_test.entity.EmployeeExceptionEntity;
import com.example.spring_security_inmemory_test.exception.EmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionEntity> employeeExceptionHandler(EmployeeException exception) {
        EmployeeExceptionEntity entity = new EmployeeExceptionEntity();
        entity.setStatus(HttpStatus.NOT_FOUND.value());
        entity.setMessage(exception.getMessage());
        entity.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.of(Optional.of(entity));
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionEntity> globalExceptionHandler(Exception exception) {
        EmployeeExceptionEntity entity = new EmployeeExceptionEntity();
        entity.setStatus(HttpStatus.BAD_REQUEST.value());
        entity.setMessage(exception.getMessage());
        entity.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.of(Optional.of(entity));
    }
}
