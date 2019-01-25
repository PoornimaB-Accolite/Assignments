package com.au.junitAssignment.Junit;

import java.util.Date;

public class StudentDetails {
	private int studentId;
	private String studentName;
	private Date dob;

	
	public StudentDetails(int studentId, String studentName, Date dob) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", studentName=" + studentName + ", dob=" + dob + "]";
	}

}
