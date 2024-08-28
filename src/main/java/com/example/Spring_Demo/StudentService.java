package com.example.Spring_Demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentService {
	@Autowired
	private StudentRepository srepository;
	
	@Autowired
	private CourseRepository crepository;
	
	
	
	public Student saveStudent(StudentDto dto) {
		Course c=new Course();
		c.setCourseName(dto.getCourseName());
		crepository.save(c);
		
		
		
		Student s=new Student();
		s.setAge(dto.getAge());
		s.setStudentName(dto.getStudentName());;
		s.setCourse(c);
		srepository.save(s);
		
		
		return s;
	}
	
	public List<Student> studentList(){
		return srepository.findAll();
	}

}
