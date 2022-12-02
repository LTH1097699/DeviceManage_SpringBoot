package com.devicespringboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "status_code", referencedColumnName = "code")
	private EmployeeStatusEntity status;
	
	@OneToMany(mappedBy = "employee")
	private List<EquipedEmployee> equipedEmployees = new ArrayList<>();
	
	@OneToOne(mappedBy = "employee")
	private AccountEntity account;
	

	public List<EquipedEmployee> getEquipedEmployees() {
		return equipedEmployees;
	}

	public void setEquipedEmployees(List<EquipedEmployee> equipedEmployees) {
		this.equipedEmployees = equipedEmployees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeStatusEntity getStatus() {
		return status;
	}

	public void setStatus(EmployeeStatusEntity status) {
		this.status = status;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

}
