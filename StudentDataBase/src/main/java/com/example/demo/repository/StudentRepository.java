package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.module.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
