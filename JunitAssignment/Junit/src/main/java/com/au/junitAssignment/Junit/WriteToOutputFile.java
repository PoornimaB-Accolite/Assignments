package com.au.junitAssignment.Junit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class WriteToOutputFile {

	public WriteToOutputFile() {

		

	}

	static void writeToOutputFile(List<StudentDetailsMarks> sortedList) throws IOException {

		Calendar calendar = Calendar.getInstance();

		String filename = "C:\\Users\\Poornima.B\\Junit\\Junit\\src\\test\\java\\com\\au\\junitAssignment\\Junit\\outputTest";

		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

		for (StudentDetailsMarks student : sortedList) {

			calendar.setTime(student.getDOB());

			writer.write(Integer.toString(student.getStudentId()) + "," + student.getStudentName() + ","
					+ calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/"
					+ calendar.get(Calendar.YEAR) + "," + student.getPercentile() + "\n");

		}

		writer.close();

	}

}
