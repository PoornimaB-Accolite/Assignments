package com.au.junitAssignment.Junit;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedDetails {

public SortedDetails() {

		

	}

	public static List<StudentDetailsMarks> sortTheMap(List<StudentDetailsMarks> fullDetails) {

		Collections.sort(fullDetails, new Comparator<StudentDetailsMarks>() {

			public int compare(StudentDetailsMarks o1,

					StudentDetailsMarks o2) {

				if (o2.getPercentile() > o1.getPercentile())
					return 1;
				else if (o1.getPercentile() > o2.getPercentile())
					return -1;

				else {
					if (o1.getDOB().compareTo(o2.getDOB()) > 0)
						return 1;
				else
						return -1;

				}

			}

		});
		return fullDetails;

	}
}
