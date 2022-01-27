package com.CourseManagementSystem.Validation;

import org.springframework.stereotype.Component;

import com.CourseManagementSystem.DTO.CourseDTO;
import com.CourseManagementSystem.DTO.StudentDTO;
import com.CourseManagementSystem.Exception.CourseException;
import com.CourseManagementSystem.Exception.StudentException;

@Component
public class Validator {

	public void validateStudentData(StudentDTO student) throws StudentException {
		if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
			throw new StudentException("Invalid student first name");
		}
		if (student.getLastName() == null || student.getLastName().isEmpty()) {
			throw new StudentException("Invalid student last name");
		}
		if (student.getEnrollmentNumber() == null || student.getEnrollmentNumber().isEmpty()) {
			throw new StudentException("Invalid student enrollment number");
		}
		if (student.getDateOfBirth() == null || student.getDateOfBirth().isEmpty()) {
			throw new StudentException("Invalid student date of birth");
		}
	}

	public void validateCourseData(CourseDTO course) throws CourseException {
		if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
			throw new CourseException("Invalid course name");
		}
		if (course.getCredits() < 0 || course.getCourseName().isEmpty()) {
			throw new CourseException("Invalid course credit");
		}
		if (course.getInstructorName() == null || course.getInstructorName().isEmpty()) {
			throw new CourseException("Invalid course instructor name");
		}
	}

}
