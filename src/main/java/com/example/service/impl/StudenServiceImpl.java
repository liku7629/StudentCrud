package com.example.service.impl;

import com.example.entity.StudentEntity;
import com.example.model.StudentRequest;
import com.example.model.StudentResponse;
import com.example.repo.StudentRepository;
import com.example.service.StudentService;
import com.example.utils.Utility;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudenServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentRequest, studentEntity);
        StudentEntity savedStudent = studentRepository.save(studentEntity);

        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(savedStudent, studentResponse);
        studentResponse.setMessage(Utility.STUDENT_SAVED_SUCCESS_MSG);

        return studentResponse;
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest) {
        StudentResponse studentResponse = createStudent(studentRequest);
        studentResponse.setMessage(Utility.STUDENT_UPDATE_SUCCESS_MSG);
        return studentResponse;
    }

    @Override
    public StudentResponse deleteStudent(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).get();
        studentRepository.delete(studentEntity);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setMessage(Utility.STUDENT_DELETE_SUCCESS_MSG);
        return studentResponse;
    }

    @Override
    public StudentResponse findStudentById(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).get();
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(studentEntity, studentResponse);
        studentResponse.setMessage(Utility.STUDENT_FETCH_SUCCESS_MSG);
        return studentResponse;
    }

    @Override
    public List<StudentResponse> findAllStudent() {
        List<StudentEntity> studentEntities = (List<StudentEntity>) studentRepository.findAll();

        List<StudentResponse> studentResponses = studentEntities.stream().map(studentEntity -> {
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(studentEntity, studentResponse);
            return studentResponse;
        }).collect(Collectors.toList());

        return studentResponses;
    }
}
