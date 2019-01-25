package com.au.junitAssignment.Junit;

public class StudentMarks {

	private int studentId;
	private String course;
	private double marks;

	public StudentMarks(int studentId, String course, int marks) {
			this.studentId = studentId;
			this.course = course;
			this.marks = marks;

	}

	public int getStudentId() {
			return studentId;
		}

	public String getCourse() {
			return course;
	}

	public double getMarks() {
		return marks;
	}

}