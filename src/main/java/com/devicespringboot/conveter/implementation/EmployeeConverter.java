package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.entity.EmployeeEntity;

@Component
public class EmployeeConverter implements IGeneralConverter<EmployeeDTO, EmployeeEntity> {

	@Override
	public EmployeeEntity toEntity(EmployeeDTO d) {
		if (d == null)
			return null;

		EmployeeEntity entity = new EmployeeEntity();
		entity.setName(d.getName());

		return entity;
	}

	@Override
	public EmployeeDTO toDTO(EmployeeEntity e) {
		if (e == null)
			return null;

		EmployeeDTO dto = new EmployeeDTO();
		dto.setName(e.getName());
		dto.setId(e.getId());
		return dto;
	}

	@Override
	public List<EmployeeEntity> toListEntity(List<EmployeeDTO> ds) {
		List<EmployeeEntity> es = new ArrayList<>();
		for(EmployeeDTO d : ds ) {
			es.add(toEntity(d));
		}
		return es;
	}

	@Override
	public List<EmployeeDTO> toListDTO(List<EmployeeEntity> es) {
		List<EmployeeDTO> ds = new ArrayList<>();
		for(EmployeeEntity e : es ) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public EmployeeEntity toOldEntity(EmployeeDTO d, EmployeeEntity oldE) {
		oldE.setName(d.getName());
		return oldE;
	}

}
