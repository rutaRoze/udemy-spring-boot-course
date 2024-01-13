package com.springboot.learn.cruddemo;

import com.springboot.learn.cruddemo.dao.StudentDAO;
import com.springboot.learn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		//return runner -> createStudent(studentDAO);

		//return runner -> createMultipleStudents(studentDAO);

		//return runner -> readStudent(studentDAO);

		//return runner -> queryForStudents(studentDAO);

		return runner -> queryForStudentsByLastName(studentDAO);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Ze");

		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student student : students) {
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student...");
		Student newStudent = new Student("Ruta", "Roze", "ruta@ruta.lt");

		System.out.println("Saving student...");
		studentDAO.save(newStudent);

		int id = newStudent.getId();
		System.out.println("Saved student. Generated id: " + id);

		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);

		System.out.println("Found student: " + myStudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating new student...");
		Student newStudent1 = new Student("Ru", "Ro", "ru@ru.lt");
		Student newStudent2 = new Student("Ra", "Ze", "ra@rze.lt");
		Student newStudent3 = new Student("Ta", "Re", "ta@re.lt");

		System.out.println("Saving student...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

		System.out.println("Saved student. Generated id: " + newStudent1.getId());
		System.out.println("Saved student. Generated id: " + newStudent2.getId());
		System.out.println("Saved student. Generated id: " + newStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student...");
		Student newStudent = new Student("Ruta", "Roze", "ruta@ruta.lt");

		System.out.println("Saving student...");
		studentDAO.save(newStudent);

		System.out.println("Saved student. Generated id: " + newStudent.getId());
	}

}
