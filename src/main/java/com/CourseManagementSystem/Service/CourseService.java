package com.CourseManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseManagementSystem.DTO.CourseDTO;
import com.CourseManagementSystem.Entity.Course;
import com.CourseManagementSystem.Exception.CourseException;
import com.CourseManagementSystem.Exception.StudentException;
import com.CourseManagementSystem.Repository.CourseRepository;
import com.CourseManagementSystem.Validation.Validator;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private Validator validate;

	public Course addNewCourse(CourseDTO course) throws CourseException {
		validate.validateCourseData(course);
		Course newCourse=new Course(course.getCourseName(), course.getCredits(), course.getInstructorName());
		return courseRepo.save(newCourse);
	}
	
	public Course getCourse(int courseId) throws StudentException {
		if(courseRepo.findById(courseId).isEmpty()) {
			throw new StudentException("Invalid course id");
		}
		return courseRepo.findById(courseId).get();
	}
	
	public Course updateCourse(int courseId, CourseDTO course) throws StudentException, CourseException {
		if(courseRepo.findById(courseId).isEmpty()) {
			throw new StudentException("Invalid course id");
		}
		validate.validateCourseData(course);
		Course oldCourse=courseRepo.findById(courseId).get();
		oldCourse.setCourseName(course.getCourseName());
		oldCourse.setCredits(course.getCredits());
		oldCourse.setInstructorName(course.getInstructorName());
		return courseRepo.save(oldCourse);
	}
	
	public void deleteCourse(int courseId) throws StudentException {
		if(courseRepo.findById(courseId).isEmpty()) {
			throw new StudentException("Invalid course id");
		}
		courseRepo.deleteById(courseId);
	}
	
	
}
