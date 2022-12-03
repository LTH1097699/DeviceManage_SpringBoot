package com.devicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devicespringboot.entity.EmployeeStatusEntity;

public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatusEntity, Long> {

}
