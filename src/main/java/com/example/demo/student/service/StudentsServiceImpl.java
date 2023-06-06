package com.example.demo.student.service;

import com.example.demo.student.domain.Student;
import com.example.demo.student.domain.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudents(Student student) {
        if(!studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            studentRepository.save(student);
            System.out.println("Student saved successfully");;
        } else {
            System.out.println("Student already in BD");
      //      throw new IllegalStateException("Email taken");
        }


    }

    @Override
    public void deleteStudents(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if(exist){
            studentRepository.deleteById(studentId);
            System.out.println("The student with the id :"+studentId+" has been deleted");

        }

        System.out.println("The student does not exist in the BD");

    }

    @Override
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        try{
            Optional<Student> student = studentRepository.findById(studentId);
            boolean condition1 = student.isPresent() && email.length() > 0 && name.length() >0;
            boolean condition2 = !Objects.equals(email, student.get().getEmail())  &&  !Objects.equals(name, student.get().getName());

            if(condition1 && condition2){
                student.get().setEmail(email);
                student.get().setName(name);
                System.out.println("Email and name changed successfully ");
            }
            else{
                System.out.println("The email and name: "+ name +" " + email + " are already in the BD");
            }
        }
         catch (Exception e){
            System.out.println( e + " The student with the id " + studentId + " is not in the BD");
        }
    }
}
