package com.au.junitAssignment.Junit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateCombinedObjectWithMarks {

	
	public static List<StudentDetailsMarks> createCombinedObjectWithMarks(List<StudentDetails> studentsList, Map<Integer, Double> marksMap) {

		List<StudentDetailsMarks> fullList = new ArrayList<StudentDetailsMarks>();

		for (StudentDetails student : studentsList) {

			fullList.add(new StudentDetailsMarks(student.getStudentId(), student.getStudentName(), student.getDob(),
					marksMap.get(student.getStudentId())));

		}

		return fullList;
	
	
}
}
