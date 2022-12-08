package com.devicespringboot.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.devicespringboot.conveter.implementation.EmployeeConverter;
import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.entity.AccountEntity;
import com.devicespringboot.entity.EmployeeEntity;
import com.devicespringboot.repository.AccountRepository;
import com.devicespringboot.service.IAccountListener;

public class AccountListener implements IAccountListener {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private EmployeeConverter employeeConverter;

	@Override
	public EmployeeDTO createAccountForEmployee(EmployeeEntity e) {
		AccountEntity account = e.getAccount();
		account.setEmployee(e);
		accountRepository.save(account);
		return employeeConverter.toDTO(e);
	}

	@Override
	public void deleteAccountForEmployee(Long emp_id) {
		accountRepository.delete(accountRepository.findByEmployeeId(emp_id));	
	}

}
