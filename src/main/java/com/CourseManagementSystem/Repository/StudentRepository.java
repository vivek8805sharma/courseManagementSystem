package com.CourseManagementSystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.CourseManagementSystem.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
