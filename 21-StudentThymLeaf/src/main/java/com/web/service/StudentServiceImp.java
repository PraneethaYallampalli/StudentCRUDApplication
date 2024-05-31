package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Student;
import com.web.repo.StudentDataRepo;

@Service
public class StudentServiceImp  implements StudentService
 {
@Autowired
public StudentDataRepo studentdataRepo;
	@Override
	public Student addstudent(Student student) {
		// TODO Auto-generated method stub
		return  studentdataRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return  studentdataRepo.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return  studentdataRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		student.setId(id);
		return studentdataRepo.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentdataRepo.deleteById(id);
	}
	
 }
