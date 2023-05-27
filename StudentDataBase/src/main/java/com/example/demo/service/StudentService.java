package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.module.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService implements IStudentService
{
	@Autowired
	private StudentRepository repo;
	
//	@Override
//	public Student addStudent(Student s) {
//			
//			return repo.save(s);
//	}
	
	@Override
	public Page<Student> loadStudentDetails(int pageno, int pagesize) {
		
		Pageable paging = PageRequest.of(pageno, pagesize);
		
		return repo.findAll(paging);
	}

	@Override
	public Page<Student> serverSideFiltering(int pageno, int pagesize,String fields) {
		
		Pageable pageable=PageRequest.of( pageno, pagesize,Sort.Direction.ASC,fields);
		return repo.findAll(pageable);
	}

	

}
