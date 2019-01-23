package com.au.spring.dao.interfaces;


import java.util.List;

import com.au.spring.model.Student;

public interface StudentDaoInterface {
	public String getName();
	public String insertStudentDetails(Student student);
	public List<Student> getAllStudentsRowMapper();
}