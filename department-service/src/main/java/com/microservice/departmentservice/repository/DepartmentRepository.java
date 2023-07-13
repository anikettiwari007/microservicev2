package com.microservice.departmentservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.departmentservice.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
	Department findByDepartmentCode(String departmenCode);
}
