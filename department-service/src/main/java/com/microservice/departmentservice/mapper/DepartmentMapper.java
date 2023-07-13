package com.microservice.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.entity.Department;

@Mapper
public interface DepartmentMapper {

	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
	
	DepartmentDto mapToDepartmentDto(Department department);
	Department mapToDepartment(DepartmentDto departmentDto);
}
