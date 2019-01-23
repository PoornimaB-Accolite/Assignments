package com.au.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.spring.dao.impl.StudentDao;
import com.au.spring.model.Student;
import com.au.spring.service.interfaces.StudentServiceInterface;

@Service
public class StudentService implements StudentServiceInterface{
	
	@Autowired
	StudentDao studentDao;
	
	public String getName() {
		return studentDao.getName();
	}

	public String insertStudentDetails(Student student) {
		return studentDao.insertStudentDetails(student);
	}

	public List<Student> getAllStudentsRowMapper() {
		return studentDao.getAllStudentsRowMapper();
	}

}