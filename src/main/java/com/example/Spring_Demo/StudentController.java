package com.example.Spring_Demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveData(@RequestBody StudentDto student) {
		Student nt= service.saveStudent(student);
		return new ResponseEntity<>(nt,HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Student>> studenList(){
		List<Student> li= service.studentList();
		return new ResponseEntity<>(li,HttpStatus.OK);
	}

}
