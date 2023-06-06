package com.example.demo.student;

import com.example.demo.student.domain.Student;
import com.example.demo.student.domain.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            Student carl = new Student("Carl","carl@email.com", LocalDate.of(2002, Month.JANUARY, 5));
            Student max = new Student( "Max","maxl@email.com",LocalDate.of(2000, Month.JANUARY, 5));
            Student pablo = new Student( "Pablo","pablo@email.com",LocalDate.of(2000, Month.JANUARY, 5));
            studentRepository.saveAll(List.of(carl, max, pablo));
        };
    }
}
