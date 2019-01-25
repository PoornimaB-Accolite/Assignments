package com.au.junitAssignment.Junit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class MarksList {

	public static List<StudentMarks> getListOfSmarks(String file) throws FileNotFoundException {
		List<StudentMarks> marksList = new ArrayList<StudentMarks>();

		try {
			if (file.equals(""))
				throw new FileNotFoundException();
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();

			String[] line;
			while ((line = csvReader.readNext()) != null) {
				marksList.add(new StudentMarks(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2])));

			}

		} catch (Exception e) {
			return null;
		}
		return marksList;
	}

}
