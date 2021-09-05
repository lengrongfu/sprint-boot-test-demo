package com.example.sprintboot.testdemo.mapper;

import com.example.sprintboot.testdemo.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@MapperScan(basePackages = "com.example.sprintboot.testdemo.mapper")
@AutoConfigureTestDatabase
@SpringBootTest(classes={DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
class StudentMapperTest {

	@Autowired
	private StudentMapper studentMapper;

	@Test
	void selectStudent() {
		Student student = studentMapper.selectStudent(0L);
		assert student == null;

		Student insert = new Student();
		insert.setAge(String.valueOf(1));
		insert.setName("张三");
		insert.setSchool("test");
		studentMapper.addStudent(insert);

		student = studentMapper.selectStudent(1L);
		assert student != null;
	}


	@Test
	void selectStudents() {
		List<Student> students = studentMapper.selectStudents();
		assert students.size() == 0;

		for (int i = 0; i < 100; i++) {
			Student student = new Student();
			student.setAge(String.valueOf(i));
			student.setName("张三");
			student.setSchool("test");
			studentMapper.addStudent(student);
		}
		List<Student> students1 = studentMapper.selectStudents();
		assert students1.size() == 100;
	}


	@Test
	void addStudent() {
		Student insert = new Student();
		insert.setAge(String.valueOf(1));
		insert.setName("张三");
		insert.setSchool("test");
		studentMapper.addStudent(insert);
		assert true;
	}
}