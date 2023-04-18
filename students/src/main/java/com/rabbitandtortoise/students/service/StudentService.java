package com.rabbitandtortoise.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitandtortoise.students.pojo.StudentPOJO;
import com.rabbitandtortoise.students.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(int stud_id, String name, String email) {

		StudentPOJO student = repository.addStudent(stud_id, name, email);

		return student;
	}

	public StudentPOJO search(int stud_id) {
		StudentPOJO student = repository.search(stud_id);
		return student;
	}

	public List<StudentPOJO> searchAll() {
		List<StudentPOJO> students = repository.searchAll();
		return students;

	}

	public int delete(int stud_id) {
		int student = repository.delete(stud_id);
		return student;
	}

	public int updateData(int stud_id, String name, String email) {
		int student = repository.update(stud_id, name, email);
		return student;
	}

}
