package com.microservice.employeeservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.employeeservice.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
