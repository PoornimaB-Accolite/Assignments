package com.au.spring.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.au.spring.model.Student;


public class StudentRowMapper implements RowMapper<Student>{
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt("id"));
		student.setStudentName(rs.getString("name"));
		return student;
	}
}