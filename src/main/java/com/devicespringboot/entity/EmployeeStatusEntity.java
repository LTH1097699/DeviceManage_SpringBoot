package com.devicespringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "emp_status")
public class EmployeeStatusEntity extends AbstractEntity {
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy = "status",fetch = FetchType.LAZY)
	private EmployeeEntity employee;

}
