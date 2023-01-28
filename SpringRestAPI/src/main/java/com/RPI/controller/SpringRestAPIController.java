package com.RPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RPI.Repo.StudentRepo;
import com.RPI.model.ServerResponse;
import com.RPI.model.Student;
import com.RPI.service.StudentSeviceImpl;

@RestController
public class SpringRestAPIController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	private StudentSeviceImpl studentSeviceImpl;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/getstulist")
	public List<Student> getStudentLit() {
		return studentSeviceImpl.getStudents(studentRepo);
	}
	
	@GetMapping("/getstu/{sid}")
	public Student getStudent(@PathVariable String sid) {
		return studentSeviceImpl.getStudent(studentRepo, Integer.parseInt(sid));
		
	}
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return studentSeviceImpl.addStudent(studentRepo,student);
	}
	
	//12 jan
	@GetMapping("/getstudentbycity/{city}")
	public List<Student> getStudentByCity(@PathVariable String city){
				
		return studentSeviceImpl.getStudentByCity(studentRepo, city);
		
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ServerResponse deleteStudent(@PathVariable String id) {
		
		return studentSeviceImpl.deleteStudent(studentRepo, Integer.parseInt(id));
	}
	
	@PutMapping("/updatestudent")
	public ServerResponse updateStudent(@RequestBody Student stu) {
		return studentSeviceImpl.updateStudent(studentRepo, stu);
	}
	
	@GetMapping("/byname/{name}")
	public ServerResponse byName(@PathVariable String name) {
		return studentSeviceImpl.byName(studentRepo, name);
	}
}
