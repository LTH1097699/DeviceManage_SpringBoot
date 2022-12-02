package com.devicespringboot.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devicespringboot.service.IEmployeeListener;


@Service
public class AccountListener implements IEmployeeListener {
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void deleteEmployee(Long id) {
		accountService.deleteAccountForEmployee(id);
		System.out.println("Delete employee id="+id);
	}

	@Override
	public void createEmployee(Long employeeId) {
		
		
	}

}
