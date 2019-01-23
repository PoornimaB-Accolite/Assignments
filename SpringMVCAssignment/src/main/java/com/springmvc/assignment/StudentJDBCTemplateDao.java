package com.springmvc.assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springmvc.assignment.Student;
import com.springmvc.assignment.StudentMapper;

@Component
public class StudentJDBCTemplateDao {

	@Autowired

	private JdbcTemplate jdbcTemplate;

	public int saveStudent(Student student) {

		String query = "insert into Student values (" + student.getId() + ",'" + student.getName() + "',"
				+ student.getAge() + " )";

		return jdbcTemplate.update(query);

	}

	public Student getById(int id) {

		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new StudentMapper());
		return student;

	}

	public List<Student> getListOfStudents() {
		String SQL = "select * from student";
		List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
		return students;
	}

}
