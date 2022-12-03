package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devicespringboot.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
}
