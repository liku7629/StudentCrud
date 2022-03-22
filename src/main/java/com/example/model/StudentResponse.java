package com.example.model;

import lombok.Data;

@Data
public class StudentResponse {
    private String message;
    private Long studentId;
    private String name;
    private String email;
    private String phoneNo;
}
