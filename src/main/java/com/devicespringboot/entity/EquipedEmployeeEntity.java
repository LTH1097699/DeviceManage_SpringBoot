package com.devicespringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "equiped_employee")
public class EquipedEmployeeEntity extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "emp_id",referencedColumnName = "id")
	private EmployeeEntity employee;

	@ManyToOne
	@JoinColumn(name = "equip_id",referencedColumnName = "id")
	private EquipmentEntity equipment;

	@OneToOne
	@JoinColumn(name = "equip_status", referencedColumnName = "id")
	private EquipmentStatusEntity status;
	
	/*
	 *  never use delete for name to avoid error of reverse word in mysql 
	 *  
	 */
	@Column(name = "ondelete")
	private Short delete;
}
