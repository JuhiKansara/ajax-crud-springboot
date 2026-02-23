package com.example.ajaxcrud.repository;

import com.example.ajaxcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface StudentRepository extends JpaRepository<Student,Long>{
}