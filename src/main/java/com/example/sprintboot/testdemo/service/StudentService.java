package com.example.sprintboot.testdemo.service;

import com.example.sprintboot.testdemo.model.Student;

import java.util.List;

public interface StudentService {

	void addStudent(Student student);

	List<Student> students();

	Student student(Long id );
}
