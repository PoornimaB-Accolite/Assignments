package com.spring.au;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		
		  System.out.println("Inserting the data into the database");
		  studentJDBCTemplate.insertStudent(10, "Poornima", 11);
		  studentJDBCTemplate.insertStudent(20, "Meena", 2);
		  studentJDBCTemplate.insertStudent(30, "Aryan", 15);
		  studentJDBCTemplate.insertStudent(40, "XYZ", 15);
		  studentJDBCTemplate.insertStudent(50, "ABC", 15);
		 
		

		System.out.println("List Of All Students");
		List<Student> students = studentJDBCTemplate.listStudentswithResultSetExtractor();
		System.out.println("With the result set Extractor");
		for (Student record : students) {
			System.out.println("Student Id : " + record.getId());
			System.out.println("Student Name : " + record.getName());
			System.out.println("Student Age : " + record.getAge());
			System.out.println("------------------------------------");
			
		}
		
		List<Student> students1 = studentJDBCTemplate.listStudentsWithRowMapper();
		System.out.println("With the result set Extractor");
		for (Student record : students1) {
			System.out.println("Student Id : " + record.getId());
			System.out.println("Student Name : " + record.getName());
			System.out.println("Student Age : " + record.getAge());
			System.out.println("------------------------------------");
			
		}
		
		System.out.println("Updating  a student");
		studentJDBCTemplate.updateStudent(20,"Sharada",40);
		
		System.out.println("Get the details of the updated student");
		Student s = studentJDBCTemplate.getStudentById(20);
		System.out.println(s);
		
		
		System.out.println("Deleting the student with iD:");
		studentJDBCTemplate.deleteStudent(90);
		
		
	}
}
