package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long studentId;
    private String name;
    private String email;
    private String phoneNo;
}
