package com.devicespringboot.dto;


import com.devicespringboot.entity.AccountEntity;

public class EmployeeDTO extends AbstractDTO<EmployeeDTO> {
	
	private String empId;
	
	private String name;
	
	private EmployeeStatusDTO status;
	
	private AccountEntity account;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeStatusDTO getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatusDTO status) {
		this.status = status;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
}
