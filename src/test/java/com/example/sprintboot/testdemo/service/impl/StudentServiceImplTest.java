package com.example.sprintboot.testdemo.service.impl;

import com.example.sprintboot.testdemo.mapper.StudentMapper;
import com.example.sprintboot.testdemo.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
class StudentServiceImplTest {

	@Mock
	private StudentMapper studentMapper;

	@InjectMocks
	private StudentServiceImpl studentService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test()
	void addStudent(){
		Student student = new Student();
		Mockito.when(studentMapper.addStudent(student)).thenReturn(1);
		studentService.addStudent(student);
	}

	@Test
	void students() {
		List<Student> students = new ArrayList<>();
		Mockito.when(studentMapper.selectStudents()).thenReturn(students);
		List<Student> students1 = studentService.students();
		assert students1.size() == 0;
	}

	@Test
	void student() {
		Student student = new Student();
		student.setId(1L);
		Mockito.when(studentMapper.selectStudent(1L)).thenReturn(student);
		Student student1 = studentService.student(1L);
		assert student1.getId().equals(1L);
	}
}