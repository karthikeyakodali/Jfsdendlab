package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository repository;

	@Override
	public String addStudent(Student s) {
		repository.save(s);
		return "Student Added Successfully";
	}

	@Override
	public String updateStudent(Student s) {
		Optional<Student> obj = repository.findById(s.getId());
        if(obj.isPresent())
        {
        	Student student = obj.get();
        	student.setName(s.getName());
        	student.setDepartment(s.getDepartment());
        	student.setEmail(s.getEmail());
        	student.setContact(s.getContact());
        	student.setAge(s.getAge());
        	student.setGender(s.getGender());
        	
        	repository.save(student);
        	return "Student Updated Successfully";
        }
        else
        {
        	return "Student ID not Found";
        }
	}

	@Override
	public String deleteStudent(int sid) {
        Optional<Student> obj = repository.findById(sid);
        if(obj.isPresent())
        {
        	Student s = obj.get();
        	repository.delete(s);
        	return "Student Deleted Successfully";
        }
        else
        {
        	return "Student ID not Found";
        }
        
	}

	@Override
	public Student displayStudentByID(int sid) {
		
	return	repository.findById(sid).get();
	}

	@Override
	public List<Student> displayallstudents() {
		
		return (List<Student>) repository.findAll();
	}
	
	
}
