package com.example.demo.student.service;

import com.example.demo.student.domain.Student;

import java.util.List;


public interface StudentService {

    List<Student> getStudents();

    void saveStudents (Student student);

    void deleteStudents(Long studentId);

    void updateStudent(Long studentId, String name, String email);
}
