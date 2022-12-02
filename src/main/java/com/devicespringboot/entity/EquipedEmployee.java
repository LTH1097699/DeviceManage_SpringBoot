package com.devicespringboot.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equiped_employee")
public class EquipedEmployee extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private EmployeeEntity employee;

	@ManyToOne
	@JoinColumn(name = "equip_id")
	private EquipmentEntity equipment;

	@OneToOne
	@JoinColumn(name = "equip_status", referencedColumnName = "code")
	private EquipmentStatusEntity status;

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public EquipmentEntity getEquipment() {
		return equipment;
	}

	public void setEquipment(EquipmentEntity equipment) {
		this.equipment = equipment;
	}

	public EquipmentStatusEntity getStatus() {
		return status;
	}

	public void setStatus(EquipmentStatusEntity status) {
		this.status = status;
	}
}
