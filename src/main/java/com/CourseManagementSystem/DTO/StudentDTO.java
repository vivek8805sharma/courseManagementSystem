package com.CourseManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

	private String enrollmentNumber;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
}
