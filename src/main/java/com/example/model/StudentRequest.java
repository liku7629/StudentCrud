package com.example.model;

import lombok.Data;

@Data
public class StudentRequest {
    private Long studentId;
    private String name;
    private String email;
    private String phoneNo;
}
