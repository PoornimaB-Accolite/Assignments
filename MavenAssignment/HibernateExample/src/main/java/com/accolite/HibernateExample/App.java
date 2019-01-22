package com.accolite.HibernateExample;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import pojo.Course;
import pojo.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Session session = factory.openSession();
        session.beginTransaction();
       /*
        
        List<Student> studentList= new ArrayList<Student>();
        
       
       
        //Adding in the Student table
        Student st = new Student();
        st.setStudentId(1);
        st.setStudentName("xyz");
        st.setStudentAge(20);
       session.save(st);
       
       Student st1 = new Student();
       st1.setStudentId(2);
       st1.setStudentName("Poornima");
       st1.setStudentAge(22);
       session.save(st1);
       
       Student st2 = new Student();
       st2.setStudentId(3);
       st2.setStudentName("Poorna");
       st2.setStudentAge(22);
       session.save(st2);
       
       session.getTransaction().commit();



       Criteria cr = session.createCriteria(Student.class); 
       cr.add(Restrictions.eq("studentId",1));
       studentList= cr.list();
       System.out.println(studentList.get(0).getStudentName());
       */

        //Adding in the course table
       
		 
		
		  Course c=new Course();
		  c.setCourseId(1);
		  c.setCourseName("Python");
		  c.setStudentId(1); 
		  session.save(c); 
		 
		 
		/*  
		  Course c1 =new Course(); 
		  c1.setCourseId(2);
		  c1.setCourseName("Java Programming");
		  c1.setStudentId(2); 
		  session.save(c1); 
		  
		  session.getTransaction().commit();
		  
		
		  List<Course> courseList= new ArrayList<Course>();
		  Criteria cr = session.createCriteria(Course.class);
		  
		  cr.add(Restrictions.eq("studentId",1)); 
		  courseList = cr.list();
		  System.out.println(courseList.size());
		 
		  
		 */
		List<Student> sList = new ArrayList<Student>();
        Student s = new Student();
		Criteria cr = session.createCriteria(Student.class);
		sList = cr.list();
		//System.out.println(sList);

		
		  for(Student student: sList)
		  {
			  System.out.println(
		  student.getStudentName()+"|" +student.getStudentAge()+"|"
		  +student.getStudentId()+"|"
		  +(!student.getCourses().isEmpty()?student.getCourses().get(0).getCourseName()
		  :"") ); }
		 
        
    }
}