package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.StudentService;


@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home()
	{
		return "Rest Api with JPA";
	}
	@PostMapping("add")
	public String addstudent(@RequestBody Student student) 
	{
		return service.addStudent(student);
	}
	
	@GetMapping("viewall")
	public List<Student> viewallstudents()
	{
		return service.displayallstudents();
	}
	@GetMapping("display")
	public Student displaystudentbyid(@RequestParam("id")  int sid)
	{
		return service.displayStudentByID(sid);
	}
	@DeleteMapping("delete")
	public String deletestudent(@RequestParam("id")  int sid)
	{
		return service.deleteStudent(sid);
	}
	@GetMapping("update")
	public String upadtestudent(@RequestBody Student s)
	{
		return service.updateStudent(s);
	}
}
