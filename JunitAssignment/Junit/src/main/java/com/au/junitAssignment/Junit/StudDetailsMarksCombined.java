package com.au.junitAssignment.Junit;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StudDetailsMarksCombined {

	public static void main(String[] args) throws IOException {

		double maxMarks = 0;

		String fileMarks = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\main\\java\\com\\au\\junitAssignment\\Junit\\file2.txt";
		List<StudentMarks> marksList = MarksList.getListOfSmarks(fileMarks);
		Map<Integer, Double> marksMap = MapOfIdMarks.mapMarks(marksList, maxMarks);
		String detailsFile = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\main\\java\\com\\au\\junitAssignment\\Junit\\file1.txt";
		List<StudentDetails> studentsList = StudentList.getStudentList(detailsFile);

		List<StudentDetailsMarks> fullList = CreateCombinedObjectWithMarks.createCombinedObjectWithMarks(studentsList,
				marksMap);
		List<StudentDetailsMarks> sortedList = SortedDetails.sortTheMap(fullList);
		WriteToOutputFile.writeToOutputFile(sortedList);

	}

}
