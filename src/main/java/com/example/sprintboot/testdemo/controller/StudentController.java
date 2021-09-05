package com.example.sprintboot.testdemo.controller;

import com.example.sprintboot.testdemo.model.Student;
import com.example.sprintboot.testdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/")
	public List<Student> getStudents(){
		return studentService.students();
	}

	@GetMapping(path = "/{id}")
	public Student getStudent(@PathVariable Long id){
		return studentService.student(id);
	}

	@PostMapping(path = "/")
	public void addStudent(Student student){
		studentService.addStudent(student);
	}

}
