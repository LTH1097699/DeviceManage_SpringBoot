package com.devicespringboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.devicespringboot.dto.EmployeeDTO;



public interface IEmployeeService extends IGeneralService<EmployeeDTO>{
	List<EmployeeDTO> findAll(Pageable pageable);
}
