package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EquipmentStatusDTO;
import com.devicespringboot.entity.EquipmentStatusEntity;


@Component
public class EquipmentStatusConverter implements IGeneralConverter<EquipmentStatusDTO, EquipmentStatusEntity>{

	@Override
	public EquipmentStatusEntity toEntity(EquipmentStatusDTO d) {
		EquipmentStatusEntity e = new EquipmentStatusEntity();
		e.setCode(d.getCode());
		e.setName(d.getName());
		return e;
	}

	@Override
	public EquipmentStatusDTO toDTO(EquipmentStatusEntity e) {
		EquipmentStatusDTO d = new EquipmentStatusDTO();
		d.setCode(e.getCode());
		d.setName(e.getName());
		d.setId(e.getId());
		return d;
	}

	@Override
	public List<EquipmentStatusEntity> toListEntity(List<EquipmentStatusDTO> ds) {
		List<EquipmentStatusEntity> es = new ArrayList<>();
		for(EquipmentStatusDTO d : ds ) {
			es.add(toEntity(d));
		}
		return es;
	}

	@Override
	public List<EquipmentStatusDTO> toListDTO(List<EquipmentStatusEntity> es) {
		List<EquipmentStatusDTO> ds = new ArrayList<>();
		for(EquipmentStatusEntity e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public EquipmentStatusEntity toOldEntity(EquipmentStatusDTO d, EquipmentStatusEntity oldE) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
