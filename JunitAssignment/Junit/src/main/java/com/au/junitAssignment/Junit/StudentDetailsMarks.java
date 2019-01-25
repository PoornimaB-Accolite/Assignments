package com.au.junitAssignment.Junit;

import java.util.Date;

public class StudentDetailsMarks {

	private int studentId;
	private String studentName;
	private Date DOB;
	private Double percentile;

	public StudentDetailsMarks(int studentId, String studentName, Date dOB, Double percentile) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.DOB = dOB;
		this.percentile = percentile;

	}

	public int getStudentId() {
		return studentId;

	}

	public String getStudentName() {
		return studentName;

	}

	public Date getDOB() {
		return DOB;

	}

	public Double getPercentile() {
		return percentile;

	}

}
