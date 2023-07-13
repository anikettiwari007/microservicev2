package com.microservice.employeeservice.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;
}
