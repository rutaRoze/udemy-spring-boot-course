package com.springboot.learn.restapidemo.controller;

import com.springboot.learn.restapidemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
                       
        return studentsList.get(studentId);
    }

}
