package com.example.controller;

import com.example.model.StudentRequest;
import com.example.model.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.findAllStudent();
    }

    @GetMapping("/{studentId}")
    public StudentResponse getStudentResponseById(@PathVariable Long studentId) {
        return studentService.findStudentById(studentId);
    }

    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @PutMapping
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentRequest);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@PathVariable Long studentId) {
        return studentService.deleteStudent(studentId);
    }
}
