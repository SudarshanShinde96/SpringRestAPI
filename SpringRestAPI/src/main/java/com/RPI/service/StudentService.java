package com.RPI.service;

import java.util.List;

import com.RPI.Repo.StudentRepo;
import com.RPI.model.ServerResponse;
import com.RPI.model.Student;

public interface StudentService {

	public List<Student> getStudents(StudentRepo sRepo);
	public Student getStudent(StudentRepo sRepo,int id);
	public Student addStudent(StudentRepo sRepo,Student student);
	
	//custom work
	public List<Student> getStudentByCity(StudentRepo sRepo,String city);
	//delete
	public ServerResponse deleteStudent(StudentRepo sRepo,int id);
	
	//put
	public ServerResponse updateStudent(StudentRepo sRepo,Student stu);
	
	//by name
	public ServerResponse byName(StudentRepo sRepo,String name);
}
