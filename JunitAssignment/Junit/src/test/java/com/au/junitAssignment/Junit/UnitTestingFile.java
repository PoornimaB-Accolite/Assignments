package com.au.junitAssignment.Junit;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.mockito.Mockito;

public class UnitTestingFile {

	public MarksList getMarksList;
	public SortedDetails getSortedDetails;
	public StudentList getStudentsList;

	public CreateCombinedObjectWithMarks main;
	public MapOfIdMarks mapMarks;
	public StudDetailsMarksCombined concatenate;
	public CalculatePercentageOfStudents calculatePercentiles;

	@BeforeClass
	public static void testMain1() throws IOException {

		// StudDetailsMarksCombined.main(null);
		System.out.println("Main started");
		new MarksList();
		new SortedDetails();
		new StudentList();
		new MapOfIdMarks();
		new CreateCombinedObjectWithMarks();
		new CalculatePercentageOfStudents();
		new WriteToOutputFile();
		new StudDetailsMarksCombined();
	}

	@Before
	public void before() {
		System.out.println("Before The testing ");
	}

	@After
	public void after() {
		System.out.println("After the method is tested");

	}

	@AfterClass
	public static void testMain2() throws IOException {
		// StudDetailsMarksCombined.main(null);
		System.out.println("The result is output to File3");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivByZero() {
		Map<Integer, Double> marksMap = new HashMap<Integer, Double>();
		marksMap.put(1, 200.0);
		marksMap.put(3, (double) 200);
		marksMap.put(4, 198.8);
		marksMap.put(5, 150.8);
		marksMap.put(8, 100.9);
		marksMap.put(6, 90.68);
		Map<Integer, Double> marks = CalculatePercentageOfStudents.percentageCaluculation(marksMap, 0.0);

		assertEquals(6, marksMap.size());

	}
	
	

	@Test(expected = Exception.class)
	public void testFileExistance2() throws FileNotFoundException {

		String testFile = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\test\\java\\com\\au\\junitAssignment\\Junit\\testedFile2";
		List<StudentMarks> students = MarksList.getListOfSmarks(testFile);

		assertEquals(6, students.size());
	}

	@Test
	public void testGetMarksList() throws FileNotFoundException {

		String testFile = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\test\\java\\com\\au\\junitAssignment\\Junit\\testedFile2";

		List<StudentMarks> marksList = MarksList.getListOfSmarks(testFile);

		assertEquals(6, marksList.size());

		assertEquals(1, marksList.get(0).getStudentId());
		assertEquals(1,marksList.get(1).getStudentId());

		
		  
		  }

	@Test(expected = Exception.class)
	public void testFileExistance1() throws FileNotFoundException {

		String testFile = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\test\\java\\com\\au\\junitAssignment\\Junit\\testedFile1";
		List<StudentDetails> students = StudentList.getStudentList(testFile);

		assertEquals(3, students.size());

	}

	@Test
	public void testGetStudentList() {

		String testFile = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\test\\java\\com\\au\\junitAssignment\\Junit\\testedFile1";
		List<StudentDetails> studentsList = StudentList.getStudentList(testFile);
		assertEquals(3, studentsList.size());
		assertEquals(1, studentsList.get(0).getStudentId());
		assertEquals("poorna", studentsList.get(0).getStudentName());
		assertEquals(2, studentsList.get(1).getStudentId());
		assertEquals(3, studentsList.get(2).getStudentId());

	}

	@Test
	public void testGetSortedList() throws ParseException {

		List<StudentDetailsMarks> students = new ArrayList<StudentDetailsMarks>();
		students.add(new StudentDetailsMarks(1, "s1", new SimpleDateFormat("dd/MM/yyyy").parse("01/07/1998"), 96.97));
		students.add(new StudentDetailsMarks(5, "s2", new SimpleDateFormat("dd/MM/yyyy").parse("04/12/1997"), 85.68));
		students.add(new StudentDetailsMarks(3, "s3", new SimpleDateFormat("dd/MM/yyyy").parse("21/02/1998"), 56.76));
		students.add(new StudentDetailsMarks(6, "s4", new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2012"), 100.00));
		students.add(new StudentDetailsMarks(8, "s5", new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2008"), 56.76));
		students.add(new StudentDetailsMarks(4, "s6", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011"), 100.00));

		List<StudentDetailsMarks> sortedList = getSortedDetails.sortTheMap(students);

		assertEquals(6, sortedList.size());
		assertEquals(4, sortedList.get(0).getStudentId());
		assertEquals(6, sortedList.get(1).getStudentId());
		assertEquals(1, sortedList.get(2).getStudentId());
		assertEquals(5, sortedList.get(3).getStudentId());
		assertEquals(3, sortedList.get(4).getStudentId());
		assertEquals(8, sortedList.get(5).getStudentId());

	}

	@Test

	public void testMapMarks() {

		List<StudentMarks> students = new ArrayList();
		students.add(new StudentMarks(1, "c1", 98));
		students.add(new StudentMarks(2, "c2", 78));
		students.add(new StudentMarks(3, "c3", 76));
		students.add(new StudentMarks(1, "c4", 47));
		students.add(new StudentMarks(2, "c5", 65));
		students.add(new StudentMarks(3, "c6", 79));
		double max = 0;

		Map<Integer, Double> marksMap = MapOfIdMarks.mapMarks(students, max);

		assertEquals(3, marksMap.size());

	}

	@Test(expected =ParseException.class)
	public void testConcatenate() throws ParseException {

		List<StudentDetails> students = new ArrayList();

			students.add(new StudentDetails(1, "s1", new SimpleDateFormat("dd/MM/yyyy").parse("01/07/1998")));
			students.add(new StudentDetails(5, "s2", new SimpleDateFormat("dd/MM/yyyy").parse("04/12/1997")));
			students.add(new StudentDetails(3, "s3", new SimpleDateFormat("dd/MM/yyyy").parse("21/02/1998")));
			students.add(new StudentDetails(6, "s4", new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2000")));
			students.add(new StudentDetails(8, "s5", new SimpleDateFormat("dd/MM/yyyy").parse("31/10/2008")));
			students.add(new StudentDetails(4, "s6", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2011")));

		Map<Integer, Double> percentileMap = new HashMap<Integer, Double>();

		percentileMap.put(1, 56.98);
		percentileMap.put(3, (double) 87);
		percentileMap.put(4, 89.65);
		percentileMap.put(5, 89.65);
		percentileMap.put(8, 100.00);
		percentileMap.put(6, 90.68);
		List<StudentDetailsMarks> student = CreateCombinedObjectWithMarks.createCombinedObjectWithMarks(students,
				percentileMap);

		assertEquals(6, student.size());
		assertEquals(1, student.get(0).getStudentId());
		assertEquals("s1", student.get(0).getStudentName());

		assertEquals(1, student.get(0).getStudentId());

	}

}
