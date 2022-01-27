package com.CourseManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registrationId;
	private int studentId;
	private int courseId;

	public CourseRegistration(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

}
