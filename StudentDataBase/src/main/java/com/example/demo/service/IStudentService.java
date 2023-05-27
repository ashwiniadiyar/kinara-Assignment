package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.module.Student;


public interface IStudentService
{
//	public Student addStudent(Student s);
	
	
	Page<Student> loadStudentDetails(int pageno,int pagesize);

	Page<Student> serverSideFiltering(int pageno, int pagesize, String fields);
}
