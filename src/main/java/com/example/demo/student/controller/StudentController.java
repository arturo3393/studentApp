package com.example.demo.student.controller;

import com.example.demo.student.domain.Student;
import com.example.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents (){
        return studentService.getStudents();
    }

    @PostMapping("/saveStudents")
    public void saveStudents (@RequestBody Student student) {
        studentService.saveStudents(student);
    }

    @DeleteMapping("/deleteStudents/{studentId}")
    public void deleteStudents (@PathVariable("studentId") Long studentId){
        studentService.deleteStudents(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email){

        studentService.updateStudent (studentId, name, email);
    }

}
