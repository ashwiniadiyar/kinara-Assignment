package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Student;
import com.example.demo.service.IStudentService;

@RestController
public class StudentController 
{
	@Autowired
	private IStudentService service;
	
//	//localhost:8080/addstudent
//		@PostMapping("/addstudent")
//		ResponseEntity<Student> addVehicle(@RequestBody Student s)
//		{
//			return new ResponseEntity<Student>(service.addStudent(s),HttpStatus.CREATED);
//		}
//	
	//localhost:8080/student/{pageno}/{pagesize}
	@GetMapping("/student/{pageno}/{pagesize}")
	Page<Student> loadStudentDetails(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return service.loadStudentDetails(pageno, pagesize);
	}
	
	//localhost:8080/student/{pageno}/{pagesize}
		@GetMapping("/student/{pageno}/{pagesize}/{fields}")
		Page<Student> serverSideFiltering(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String fields)
		{
			return service.serverSideFiltering(pageno, pagesize, fields);
		}
	
}
