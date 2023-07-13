package com.microservice.departmentservice.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.departmentservice.dto.DepartmentDto;
import com.microservice.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		return new ResponseEntity<DepartmentDto>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable UUID id){
//		return new ResponseEntity<DepartmentDto>(departmentService.findDepartment(id), HttpStatus.OK);
//	}
	
	@GetMapping("/{departmentCode}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
		return new ResponseEntity<DepartmentDto>(departmentService.findDepartmentByDeptCode(departmentCode), HttpStatus.OK);
	}
}
