package com.example.sprintboot.testdemo.mapper;

import com.example.sprintboot.testdemo.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

	@Select("select * from student")
	List<Student> selectStudents();

	@Select("select * from student where id=#{id}")
	Student selectStudent(Long id);

	@Insert("insert into student(name,age,school) values(#{name},#{age},#{school})")
	int addStudent(Student student);

}
