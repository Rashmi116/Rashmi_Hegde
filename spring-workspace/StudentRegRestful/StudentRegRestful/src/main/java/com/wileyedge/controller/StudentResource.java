package com.wileyedge.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.wileyedge.exceptionhandling.StudentNotFoundException;
import com.wileyedge.model.Student;
import com.wileyedge.service.IService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentResource {
	
	@Autowired
	private IService service;
	
	@GetMapping(path="/students")
	public List<Student> retrieveAllStudents(){
		System.out.println("Inside retrieveAllStudents() of StudentResource");
		return service.findAll();
	}
	@GetMapping(path="/students/{id}")
	public Student retrieveStudent(@PathVariable("id") int id){
		System.out.println("Inside retrieveStudent() of StudentResource "+id);
		Optional<Student> opt = service.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			System.out.println("Throwing Exception");
			throw new StudentNotFoundException("id = "+id+" not found");
		}		
	}
	
	@PostMapping(path="/students", consumes = "application/json")
	public String createStudent(@Valid @RequestBody Student stud, BindingResult result, Model model) throws MethodArgumentNotValidException {
		System.out.println("Inside createStudent() of StudentResource");
		if(result.hasErrors()) {
			System.out.println("Validation errors occurred");
			throw new MethodArgumentNotValidException(null, result);
		}
		service.save(stud);
		return "added";
	}
	@DeleteMapping(path="/students/{id}")
	public String deleteUser(@PathVariable int id) {
		System.out.println("inside deleteuser of studentresource");
		service.deleteById(id);
		return "deleted";
	}
	@GetMapping(path = "/students/name/{name}")
	public List<Student> retriveUserByName(@PathVariable String name){
		System.out.println("Inside retriveUserByName() of studentResource");
		List<Student> users =  service.findByName(name);
		if(users==null) {
			throw new StudentNotFoundException(name+ " not found");
		}
		return users;
	}
}
