package com.CourseManagementSystem.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.CourseManagementSystem.Entity.CourseRegistration;

public interface RegistrationRepository extends CrudRepository<CourseRegistration, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="DELETE from course_registration e where e.student_id=:studentId and e.course_id=:courseId" , nativeQuery = true)
	public boolean unregisterStudent(@Param("studentId") int studentId, @Param("courseId") int courseId );
	
	public List<CourseRegistration> findByStudentId(int studentId);
	
	public List<CourseRegistration> findByCourseId(int courseId);
	
	public List<CourseRegistration> findByCourseIdAndStudentId(int courseId, int studentId);
	
	

}
