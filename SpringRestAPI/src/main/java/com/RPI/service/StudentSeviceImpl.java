package com.RPI.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RPI.Repo.StudentRepo;
import com.RPI.model.ServerResponse;
import com.RPI.model.Student;

@Service
public class StudentSeviceImpl implements StudentService {

	List<Student> sList;
	@Override
	public List<Student> getStudents(StudentRepo sRepo) {
		
		sList= new LinkedList<Student>();
		Iterable<Student> itr=sRepo.findAll();
		Iterator<Student> itrIterator=itr.iterator();
		while (itrIterator.hasNext()) {
			Student student = (Student) itrIterator.next();
			sList.add(student);
		}
		return sList;
		
	}

	@Override
	public Student getStudent(StudentRepo sRepo, int id) {

		Optional<Student> optional=sRepo.findById(id);
		Student s=optional.get();
		return s;
	}

	@Override
	public Student addStudent(StudentRepo sRepo, Student student) {

		sRepo.save(student);
		return student;
	}
	
	
//20jan
	
	@Override
	public List<Student> getStudentByCity(StudentRepo sRepo, String city) {
		sList =getStudents(sRepo);
		List<Student> myList=new LinkedList<Student>();
		for (Student s : sList) {
			if (s.getAddress().equalsIgnoreCase(city)) {
				myList.add(s);
			}
		}
		return myList;
	}

	@Override
	public ServerResponse deleteStudent(StudentRepo sRepo, int id) {
		Student s =getStudent(sRepo,id);
		ServerResponse sr=new ServerResponse();
		if (s!=null) {
			sRepo.delete(s);
			sr.setMessage("Record Deleted");
			sr.setStatus(200);
		}
		else {
			sr.setMessage("no record found to delete");
			sr.setStatus(200);
		}
		return sr;
	}

	@Override
	public ServerResponse updateStudent(StudentRepo sRepo, Student stu) {
		Student s =getStudent(sRepo,stu.getSid());
		ServerResponse sr=new ServerResponse();
		if (stu.getSid()==0) {
			sr.setMessage("No Record Found To update");
			sr.setStatus(200);
		}
		else {
			s.setAddress(stu.getAddress());
			s.setAge(stu.getAge());
			sRepo.save(s);
			sr.setMessage("Record updated");
			sr.setStatus(200);
		}
		return sr;
	}

	@Override
	public ServerResponse byName(StudentRepo sRepo, String name) {
		
		List<Student> record=sRepo.getStudentByName(name);
		ServerResponse sr=new ServerResponse();
		if(record.size()!=0) {
			sr.setsList(record);
			sr.setMessage("Record Found");
			sr.setStatus(200);
		}else {
			sr.setMessage("REcord Not Found");
			sr.setStatus(200);
		}
		return sr;
	}

	
	
}
