package com.microservice.departmentservice.service;

import java.util.UUID;

import com.microservice.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto findDepartment(UUID departmentId);
	DepartmentDto getAll();
	DepartmentDto updateDepartment(UUID id, DepartmentDto departmentDto);
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	void deleteDepartment(UUID id);
	DepartmentDto findDepartmentByDeptCode(String departmentCode);
}
