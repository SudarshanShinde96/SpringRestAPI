package com.RPI.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.RPI.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

	@Query("select s from Student s where s.name LIKE %?1%")
	public List<Student> getStudentByName(String name);
}
