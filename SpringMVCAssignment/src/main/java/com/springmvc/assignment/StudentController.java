package com.springmvc.assignment;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@RequestMapping(value = "/home")
	public String hellowPage() {
		return "index";
	}

	@RequestMapping(value = "/getStudents", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Student> getListOfStudents() {

		Student student = new Student();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentJDBCTemplateDao jdbcTemplateDao = (StudentJDBCTemplateDao) applicationContext
				.getBean(StudentJDBCTemplateDao.class);
		List<Student> studentList = jdbcTemplateDao.getListOfStudents();
		return studentList;
	}

	@RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Student getStudent(@PathVariable("id") int id) {
		Student student = new Student();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentJDBCTemplateDao jdbcTemplateDao = (StudentJDBCTemplateDao) applicationContext
				.getBean(StudentJDBCTemplateDao.class);
		Student student1 = jdbcTemplateDao.getById(id);
		if (student1 == null) {
			System.out.println("Student Does not exists");
		}
		return student1;
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public void addStudent(@RequestParam("stdname") String stdName, @RequestParam("studentid") int stdID,

			@RequestParam("sage") int age) {

		Student student = new Student();
		student.setId(stdID);
		student.setName(stdName);
		student.setAge(age);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentJDBCTemplateDao jdbcTemplateDao = (StudentJDBCTemplateDao) applicationContext
				.getBean(StudentJDBCTemplateDao.class);
		jdbcTemplateDao.saveStudent(student);
		System.out.println("Student saved with id :"+student.getId());
	}

}
