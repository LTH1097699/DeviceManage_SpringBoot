package com.devicespringboot.dto;

import javax.validation.constraints.NotEmpty;

public class EquipmentTypeDTO extends AbstractDTO<EquipmentTypeDTO> {
	@NotEmpty
	private String code;
	@NotEmpty
	private String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
