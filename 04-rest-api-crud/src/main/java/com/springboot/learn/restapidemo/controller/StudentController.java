package com.springboot.learn.restapidemo.controller;

import com.springboot.learn.restapidemo.entity.Student;
import com.springboot.learn.restapidemo.exeption.StudentErrorResponse;
import com.springboot.learn.restapidemo.exeption.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> studentsList;

    @PostConstruct
    public void loadData() {

        studentsList = new ArrayList<>();

        studentsList.add(new Student("Ruta", "Roze"));
        studentsList.add(new Student("Tomas", "Lotas"));
        studentsList.add(new Student("Darius", "Natas"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return studentsList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if ((studentId >= studentsList.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return studentsList.get(studentId);
    }

}
