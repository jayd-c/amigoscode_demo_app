package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mariam","Mariam@gmail.com", LocalDate.of(2001, Month.JANUARY,5)));
        students.add(new Student("Alex","Alex@gmail.com", LocalDate.of(1979, Month.MARCH,25)));
        students.add(new Student("Brian","brian@gmail.com", LocalDate.of(1984, Month.JANUARY,5)));
        return args -> {

            repository.saveAll(students);
            System.out.println(Period.between(LocalDate.ofEpochDay(LocalDate.now().getYear()),LocalDate.of(1979,03,25)));
        };
    }
}
