package com.security.springcomplesecurity.student;

public class Student {

	private final Integer studentId;
	private final String studentName;
	
	
//	public Student() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public Student(Integer studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	
	
	
	
}
