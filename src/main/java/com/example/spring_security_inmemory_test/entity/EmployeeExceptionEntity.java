package com.example.spring_security_inmemory_test.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeExceptionEntity {
    private int status;
    private String message;
    private long timestamp;
}
