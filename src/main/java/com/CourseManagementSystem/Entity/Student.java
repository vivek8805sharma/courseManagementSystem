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
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String enrollmentNumber;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	public Student(String enrollmentNumber, String firstName, String lastName, String dateOfBirth){
		this.enrollmentNumber=enrollmentNumber;
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
	}
	

}
