package com.devicespringboot.dto;

import org.springframework.web.multipart.MultipartFile;

public class EquipmentDTO extends AbstractDTO<EquipmentDTO> {
	private String equipId;

	private String name;
	
	private String file;
	
	private MultipartFile multipartFile;
	
	private EquipmentStatusDTO status;
	
	private EquipmentTypeDTO type;

	private String description;

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

	public EquipmentStatusDTO getStatus() {
		return status;
	}

	public void setStatus(EquipmentStatusDTO status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public EquipmentTypeDTO getType() {
		return type;
	}

	public void setType(EquipmentTypeDTO type) {
		this.type = type;
	}
	
}
