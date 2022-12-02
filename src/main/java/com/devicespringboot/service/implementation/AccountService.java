package com.devicespringboot.service.implementation;

import org.springframework.stereotype.Service;

@Service
public class AccountService  {
	public void deleteAccountForEmployee(Long empployeeId) {
		System.out.println("Delete account for employee id="+empployeeId);
	} 
	public void createAccountForEmployee(Long employeeId) {
		
	}
	
}
