package com.au.spring.service.interfaces;



import java.util.List;

import com.au.spring.model.Student;


public interface StudentServiceInterface {
	public String getName();
	public String insertStudentDetails(Student student);
	public List<Student> getAllStudentsRowMapper();
}