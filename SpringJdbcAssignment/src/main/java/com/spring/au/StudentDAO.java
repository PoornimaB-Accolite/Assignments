package com.spring.au;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource ds);

	public void insertStudent(int id, String name, int age);
	
	public void updateStudent(int id,String name, int age);
	
	public Student getStudentById(int id);
	
	public void deleteStudent(int id); 

	public List<Student> listStudentsWithRowMapper();
	public List<Student> listStudentswithResultSetExtractor();
}