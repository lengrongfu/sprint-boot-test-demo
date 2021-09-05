package com.example.sprintboot.testdemo.service.impl;

import com.example.sprintboot.testdemo.mapper.StudentMapper;
import com.example.sprintboot.testdemo.model.Student;
import com.example.sprintboot.testdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public void addStudent(Student student) {
		studentMapper.addStudent(student);
	}

	@Override
	public List<Student> students() {
		return studentMapper.selectStudents();
	}

	@Override
	public Student student(Long id) {
		return studentMapper.selectStudent(id);
	}
}
