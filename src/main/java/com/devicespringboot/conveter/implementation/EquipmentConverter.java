package com.devicespringboot.conveter.implementation;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.entity.EquipmentEntity;



@Component
public class EquipmentConverter implements IGeneralConverter<EquipmentDTO, EquipmentEntity>{

	@Override
	public EquipmentEntity toEntity(EquipmentDTO d) {
		EquipmentEntity e = new EquipmentEntity();
		e.setName(d.getName());
		e.setDescription(d.getDescription());
		
		e.setEquipId(d.getEquipId());
		return e;
	}

	@Override
	public EquipmentDTO toDTO(EquipmentEntity e) {
		EquipmentDTO d = new EquipmentDTO();
		d.setName(e.getName());
		d.setDescription(e.getDescription());
		d.setId(e.getId());
		d.setEquipId(e.getEquipId());
		return d;
	}

	@Override
	public List<EquipmentEntity> toListEntity(List<EquipmentDTO> ds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentDTO> toListDTO(List<EquipmentEntity> es) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipmentEntity toOldEntity(EquipmentDTO d, EquipmentEntity oldE) {
		// TODO Auto-generated method stub
		return null;
	}

}
