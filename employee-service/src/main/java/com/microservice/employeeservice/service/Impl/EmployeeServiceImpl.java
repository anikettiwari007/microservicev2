package com.microservice.employeeservice.service.Impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.employeeservice.dto.APIResponseDto;
import com.microservice.employeeservice.dto.DepartmentDto;
import com.microservice.employeeservice.dto.EmployeeDto;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.mapper.EmployeeMapper;
import com.microservice.employeeservice.repository.EmployeeRepository;
import com.microservice.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;
	//private final RestTemplate restTemplate;
	private final WebClient webClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee emp = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
		Employee savedEmp = employeeRepository.save(emp);
		EmployeeDto empDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmp);
		return empDto;
	}

	@Override
	public APIResponseDto getEmployee(UUID id) {
		if(employeeRepository.findById(id).isPresent()) {
			Employee emp = employeeRepository.findById(id).get();
			//ResponseEntity<DepartmentDto> departmentEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/"+ emp.getDepartmentCode(), DepartmentDto.class);
			
			DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/v1/department/"+ emp.getDepartmentCode())
					.retrieve().bodyToMono(DepartmentDto.class).block();
			
			EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(emp);
			return new APIResponseDto(employeeDto, departmentDto);
		}
		else {
			return null;
		}
	}
}
