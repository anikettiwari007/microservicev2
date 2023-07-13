package com.microservice.departmentservice.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.mapper.DepartmentMapper;
import com.microservice.departmentservice.repository.DepartmentRepository;
import com.microservice.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	private final DepartmentRepository departmentRepository;
	@Override
	public DepartmentDto findDepartment(UUID departmentId) {
		if(departmentRepository.findById(departmentId).isPresent()) {
			return DepartmentMapper.MAPPER.mapToDepartmentDto(departmentRepository.findById(departmentId).get());
		}
		else {	
			return null;
		}		
	}

	@Override
	public DepartmentDto getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentDto updateDepartment(UUID id, DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		DepartmentDto savedDeptDto = DepartmentMapper.MAPPER.mapToDepartmentDto(departmentRepository.save(DepartmentMapper.MAPPER.mapToDepartment(departmentDto)));
		return savedDeptDto;
	}

	@Override
	public void deleteDepartment(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartmentDto findDepartmentByDeptCode(String departmentCode) {
		return DepartmentMapper.MAPPER.mapToDepartmentDto(departmentRepository.findByDepartmentCode(departmentCode));
	}

}
