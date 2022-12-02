package com.devicespringboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "equipment")
public class EquipmentEntity extends AbstractEntity {
	@Column(name = "equip_id")
	private String equipId;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "equip_status", referencedColumnName = "code")
	private EquipmentStatusEntity status;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "equipment")
	private List<EquipedEmployee> equipedEmployees; 
	
	@ManyToOne
	@JoinColumn(name = "type_id",referencedColumnName = "id")
	private EquipmentTypeEntity equipmentType;
	
	public List<EquipedEmployee> getEquipedEmployees() {
		return equipedEmployees;
	}

	public void setEquipedEmployees(List<EquipedEmployee> equipedEmployees) {
		this.equipedEmployees = equipedEmployees;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public EquipmentStatusEntity getStatus() {
		return status;
	}

	public void setStatus(EquipmentStatusEntity status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EquipmentTypeEntity getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentTypeEntity equipmentType) {
		this.equipmentType = equipmentType;
	}
	
	
	
	

}
