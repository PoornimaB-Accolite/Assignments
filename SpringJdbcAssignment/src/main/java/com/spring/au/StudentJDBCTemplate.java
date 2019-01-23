package com.spring.au;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void insertStudent(int id, String name, int age) {
		String SQL = "insert into student (id, name, age) values (?, ?, ?)";

		jdbcTemplateObject.update(SQL, id, name, age);
		System.out.println("Student inserted with = " + name + " Age = " + age);
		return;
	}

	// Using Student Mapper is RowMapper object to map each fetched record to
	// student object

	public List<Student> listStudentsWithRowMapper() {
		String SQL = "select * from student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	public List<Student> listStudentswithResultSetExtractor() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new ResultSetExtractor<List<Student>>() {

			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Student> list = new ArrayList<Student>();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setAge(rs.getInt("age"));
					list.add(student);
				}
				return list;
			}
		});
		return students;
	}

	public void updateStudent(int id, String name, int age) {
		try {
			String SQL = "select * from Student where id = ?";
			Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());

			String SQL1 = "update Student set age = ?,name = ? where id = ?";
			jdbcTemplateObject.update(SQL1, age, name, id);
			System.out.println("Student updated with Id = " + id);
			return;
		} catch (Exception e) {
			System.out.println("student does not exists with Id");
		}

	}

	public Student getStudentById(int id) {
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());

		return student;
	}

	public void deleteStudent(int id) {
		try {
			String SQL = "select * from Student where id = ?";
			Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());
			String SQL1 = "delete from Student where id = ?";
			jdbcTemplateObject.update(SQL1, id);
			System.out.println("Student deleted with Id = " + id);
			return;
		} catch (Exception e) {
			System.out.println("Student Does not exists with Id " + id);
		}
		return;

	}

	}