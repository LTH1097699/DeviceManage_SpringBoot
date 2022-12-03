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
@Table(name = "equipment")
public class EquipmentEntity extends AbstractEntity {
	@Column(name = "equip_id")
	private String equipId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "equipment", fetch = FetchType.LAZY)
	private List<EquipedEmployeeEntity> equipedEmployees; 
	
	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName = "id")
	private EquipmentTypeEntity equipmentType;
	
	@OneToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private EquipmentStatusEntity status;
	
	
	
	
	
	

}
