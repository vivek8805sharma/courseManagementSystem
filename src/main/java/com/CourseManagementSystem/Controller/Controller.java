package com.CourseManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CourseManagementSystem.DTO.CourseDTO;
import com.CourseManagementSystem.DTO.StudentDTO;
import com.CourseManagementSystem.Entity.Course;
import com.CourseManagementSystem.Entity.CourseRegistration;
import com.CourseManagementSystem.Entity.Student;
import com.CourseManagementSystem.Exception.CourseException;
import com.CourseManagementSystem.Exception.RegistrationException;
import com.CourseManagementSystem.Exception.StudentException;
import com.CourseManagementSystem.Service.CourseService;
import com.CourseManagementSystem.Service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = { "Coures management controller" })
public class Controller {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@PostMapping("/student/create")
	@ApiOperation(value = "Add new student")
	public ResponseEntity<?> addStudent(@RequestBody StudentDTO student) throws StudentException {
		return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.OK);
	}

	@GetMapping("/student/{studentId}")
	@ApiOperation(value = "Get a student")
	public ResponseEntity<Student> getStudent(@PathVariable int studentId) throws StudentException {
		return new ResponseEntity<Student>(studentService.getStudent(studentId), HttpStatus.OK);
	}

	@DeleteMapping("/student/{studentId}")
	@ApiOperation(value = "Delete a student")
	public ResponseEntity<?> deleteStudent(@PathVariable int studentId) throws StudentException {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<>(studentId, HttpStatus.OK);
	}

	@PutMapping("/student/{studentId}")
	@ApiOperation(value = "Update a student")
	public ResponseEntity<Student> updateStudent(@PathVariable int studentId, @RequestBody StudentDTO student)
			throws StudentException {
		return new ResponseEntity<>(studentService.updateStudent(studentId, student), HttpStatus.OK);
	}

	// Course

	@PostMapping("/course/create")
	@ApiOperation(value = "Add new course")
	public ResponseEntity<?> addCourse(@RequestBody CourseDTO course) throws CourseException {
		return new ResponseEntity<>(courseService.addNewCourse(course), HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}")
	@ApiOperation(value = "Get a course")
	public ResponseEntity<Course> getCourse(@PathVariable int courseId) throws StudentException {
		return new ResponseEntity<Course>(courseService.getCourse(courseId), HttpStatus.OK);
	}

	@DeleteMapping("/course/{courseId}")
	@ApiOperation(value = "Delete a course")
	public ResponseEntity<?> deleteCourse(@PathVariable int courseId) throws StudentException {
		courseService.deleteCourse(courseId);
		return new ResponseEntity<>(courseId, HttpStatus.OK);
	}

	@PutMapping("/course/{courseId}")
	@ApiOperation(value = "Update a course")
	public ResponseEntity<Course> updateCourse(@PathVariable int courseId, @RequestBody CourseDTO course)
			throws StudentException, CourseException {
		return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.OK);
	}

	// registration

	@PostMapping("/student/{studentId}/course/{courseId}")
	@ApiOperation(value = "Register a student for course")
	public ResponseEntity<CourseRegistration> registerStudent(@PathVariable int studentId, @PathVariable int courseId)
			throws StudentException, CourseException, RegistrationException {
		return new ResponseEntity<>(studentService.registerStudent(studentId, courseId), HttpStatus.OK);
	}

	@DeleteMapping("/student/{studentId}/course/{courseId}")
	@ApiOperation(value = "Unregister a student for course")
	public ResponseEntity<CourseRegistration> unregisterStudent(@PathVariable int studentId, @PathVariable int courseId)
			throws StudentException, CourseException, RegistrationException {
		studentService.unregisterStudent(studentId, courseId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// find all
	@GetMapping("/student/{studentId}/course")
	@ApiOperation(value = "Get all courses of a student")
	public ResponseEntity<List<Course>> findAllCoursesForStudent(@PathVariable int studentId) throws StudentException {
		return new ResponseEntity<>(studentService.findAllCoursesForStudent(studentId), HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}/student")
	@ApiOperation(value = "Get all students of a course")
	public ResponseEntity<List<Student>> findAllStudentForCourse(@PathVariable int courseId)
			throws StudentException, CourseException {
		return new ResponseEntity<>(studentService.findAllStudentForCourse(courseId), HttpStatus.OK);
	}

}
