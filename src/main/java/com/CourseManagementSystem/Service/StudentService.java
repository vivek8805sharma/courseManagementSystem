package com.CourseManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseManagementSystem.DTO.StudentDTO;
import com.CourseManagementSystem.Entity.Course;
import com.CourseManagementSystem.Entity.CourseRegistration;
import com.CourseManagementSystem.Entity.Student;
import com.CourseManagementSystem.Exception.CourseException;
import com.CourseManagementSystem.Exception.RegistrationException;
import com.CourseManagementSystem.Exception.StudentException;
import com.CourseManagementSystem.Repository.RegistrationRepository;
import com.CourseManagementSystem.Repository.StudentRepository;
import com.CourseManagementSystem.Validation.Validator;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private RegistrationRepository registrationRepo;

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private Validator validate;

	public Student addNewStudent(StudentDTO student) throws StudentException {
		validate.validateStudentData(student);
		Student newStudent = new Student(student.getEnrollmentNumber(), student.getFirstName(), student.getLastName(),
				student.getDateOfBirth());
		return studentRepo.save(newStudent);
	}

	public Student getStudent(int studentId) throws StudentException {
		if (studentRepo.findById(studentId).isEmpty()) {
			throw new StudentException("Invalid student id");
		}
		return studentRepo.findById(studentId).get();
	}

	public Student updateStudent(int studentId, StudentDTO student) throws StudentException {
		if (studentRepo.findById(studentId).isEmpty()) {
			throw new StudentException("Invalid student id");
		}
		validate.validateStudentData(student);
		Student oldStudent = studentRepo.findById(studentId).get();
		oldStudent.setEnrollmentNumber(student.getEnrollmentNumber());
		oldStudent.setFirstName(student.getFirstName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setDateOfBirth(student.getDateOfBirth());
		return studentRepo.save(oldStudent);
	}

	public void deleteStudent(int studentId) throws StudentException {
		if (studentRepo.findById(studentId).isEmpty()) {
			throw new StudentException("Invalid student id");
		}
		studentRepo.deleteById(studentId);
	}

	public CourseRegistration registerStudent(int studentId, int courseId) throws StudentException, CourseException, RegistrationException {
		if (studentRepo.findById(studentId).isEmpty()) {
			throw new StudentException("Invalid student id");
		}
		if (courseService.getCourse(courseId) == null) {
			throw new CourseException("Invalid course id");
		}
		if(!registrationRepo.findByCourseIdAndStudentId(courseId, studentId).isEmpty()) {
			throw new RegistrationException("Student alreday registered for the course");
		}
		CourseRegistration reg = new CourseRegistration(studentId, courseId);
		registrationRepo.save(reg);
		return reg;
	}

	public void unregisterStudent(int studentId, int courseId)
			throws StudentException, CourseException, RegistrationException {
		if (studentRepo.findById(studentId).isEmpty()) {
			throw new StudentException("Invalid student id");
		}
		if (courseService.getCourse(courseId) == null) {
			throw new CourseException("Invalid course id");
		}
		if(registrationRepo.findByCourseIdAndStudentId(courseId, studentId).isEmpty()) {
			throw new RegistrationException("Invalid registration");
		}
		registrationRepo.unregisterStudent(studentId, courseId);
	}

	public List<Course> findAllCoursesForStudent(int studentId) throws StudentException {
		if (studentRepo.findById(studentId).isEmpty()) {
			throw new StudentException("Invalid student id");
		}
		List<CourseRegistration> cr = registrationRepo.findByStudentId(studentId);
		List<Course> allCourses = new ArrayList<>();
		for (CourseRegistration reg : cr) {
			allCourses.add(courseService.getCourse(reg.getCourseId()));
		}
		return allCourses;

	}

	public List<Student> findAllStudentForCourse(int courseId) throws StudentException, CourseException {
		if (courseService.getCourse(courseId) == null) {
			throw new CourseException("Invalid course id");
		}
		List<CourseRegistration> cr = registrationRepo.findByCourseId(courseId);
		List<Student> allStudents = new ArrayList<>();
		for (CourseRegistration reg : cr) {
			allStudents.add(this.getStudent(reg.getStudentId()));
		}
		return allStudents;

	}

}
