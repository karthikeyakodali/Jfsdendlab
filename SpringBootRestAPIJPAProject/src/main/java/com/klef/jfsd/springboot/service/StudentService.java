package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Student;

public interface StudentService 
{
	public String addStudent(Student s);
	public String updateStudent(Student s);
	public String deleteStudent(int sid);
	public Student displayStudentByID(int sid );
	public List<Student> displayallstudents();

}
