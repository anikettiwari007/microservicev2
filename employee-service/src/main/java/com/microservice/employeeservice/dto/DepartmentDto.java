package com.microservice.employeeservice.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
	private UUID id;
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
}
