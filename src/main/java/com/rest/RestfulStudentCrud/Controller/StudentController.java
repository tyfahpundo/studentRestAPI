package com.rest.RestfulStudentCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.RestfulStudentCrud.Entity.Student;
import com.rest.RestfulStudentCrud.Repository.StudentRepository;
import com.rest.RestfulStudentCrud.Exception.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired StudentRepository studentRepository;
	
	//get all Students
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	//get Student by Id
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable (value="id") int studId) {
		return this.studentRepository.findById(studId).orElseThrow();
	}
	//Create Student
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return this.studentRepository.save(student);
	}
	//Update Student 
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable(value="id") int studId) {
		Student existingStudent = this.studentRepository.findById(studId).orElseThrow();
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setStudAge(student.getStudAge());
		existingStudent.setGenderId(student.getGenderId());
		return this.studentRepository.save(existingStudent);
	}
	//Delete Student by Id
	@DeleteMapping
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") int studId){
		Student existingStudent = this.studentRepository.findById(studId).orElseThrow();
		this.studentRepository.delete(existingStudent);
		return ResponseEntity.ok().build();
	}

}
