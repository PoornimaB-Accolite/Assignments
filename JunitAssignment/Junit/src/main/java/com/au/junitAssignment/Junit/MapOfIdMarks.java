package com.au.junitAssignment.Junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfIdMarks {

	public MapOfIdMarks()
	{
		
	}
	public static Map<Integer, Double> mapMarks(List<StudentMarks> marksList, double maxMarks) {

		Map<Integer, Double> marksMap = new HashMap<Integer, Double>();

		for (StudentMarks student : marksList) {

			if (marksMap.containsKey(student.getStudentId())) {

				Double total = marksMap.get(student.getStudentId()) + student.getMarks();
				marksMap.put(student.getStudentId(), total);
				if (marksMap.get(student.getStudentId()) > maxMarks) {
					maxMarks = marksMap.get(student.getStudentId());

				}

			}

			else {
				marksMap.put(student.getStudentId(), student.getMarks());

			}
		}
		return CalculatePercentageOfStudents.percentageCaluculation(marksMap, maxMarks);
	}

}
