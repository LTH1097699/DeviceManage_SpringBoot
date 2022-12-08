package com.devicespringboot.service;

import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.entity.EmployeeEntity;

public interface IAccountListener {
	EmployeeDTO createAccountForEmployee(EmployeeEntity e);
	void deleteAccountForEmployee(Long emp_id);
}
