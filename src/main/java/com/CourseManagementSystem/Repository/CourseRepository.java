package com.CourseManagementSystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.CourseManagementSystem.Entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

}
