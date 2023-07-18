package com.security.springcomplesecurity;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springcomplesecurity.student.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> STUDENT = Arrays.asList(
			new Student(1, "zain"), 
			new Student(2, "jawad"),
			new Student(3, "Abu Bakar"));

	@GetMapping(path="{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		
		return STUDENT.stream()
				.filter(student -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("student"+studentId+" not exists"));
				
		
	}

}
