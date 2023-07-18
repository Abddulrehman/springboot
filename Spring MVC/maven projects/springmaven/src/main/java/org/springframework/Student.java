package org.springframework;

public class Student {

	
	
	private Integer studentId;
	private String studentName;
	private String email;
	
	
	public Student() {
		super();
		
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(Integer studentId, String studentName, String email) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + "]";
	}
	
	
	
}
