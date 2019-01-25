package com.au.junitAssignment.Junit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class StudentList {

	public static List<StudentDetails> getStudentList(String file) {
		List<StudentDetails> studentsList = new ArrayList<StudentDetails>();

		try {

			if (file.equals(""))

				throw new FileNotFoundException();

			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			String[] line;

			while ((line = csvReader.readNext()) != null) {

				studentsList.add(new StudentDetails(Integer.parseInt(line[1]), line[0],
						new SimpleDateFormat("dd/MM/yyyy").parse(line[2])));

			}

		}

		catch (Exception e) {
			return null;

		}
		return studentsList;

	}
}
