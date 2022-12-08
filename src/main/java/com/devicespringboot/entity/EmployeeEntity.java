package com.devicespringboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "avatar")
	private String avatar;
	
	@ManyToOne
	@JoinColumn(name = "status_code", referencedColumnName = "id")
	private EmployeeStatusEntity status;
	
	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
	private List<EquipedEmployeeEntity> equipedEmployees;
	
	@OneToOne(mappedBy = "employee")
	private AccountEntity account;
	

}
