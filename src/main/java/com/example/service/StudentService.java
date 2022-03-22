package com.example.service;

import com.example.model.StudentRequest;
import com.example.model.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest studentRequest);
    StudentResponse updateStudent(StudentRequest studentRequest);
    StudentResponse deleteStudent(Long studentId);
    StudentResponse findStudentById(Long studentId);
    List<StudentResponse> findAllStudent();
}
