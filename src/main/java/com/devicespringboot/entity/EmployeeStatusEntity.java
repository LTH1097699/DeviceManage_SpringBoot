package com.devicespringboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "status",fetch = FetchType.LAZY)
	private List<EmployeeEntity> employee;

}
