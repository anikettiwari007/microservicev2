package com.microservice.employeeservice.service;

import java.util.UUID;

import com.microservice.employeeservice.dto.APIResponseDto;
import com.microservice.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	APIResponseDto getEmployee(UUID id);
}
