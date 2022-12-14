package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EmployeeStatusDTO;
import com.devicespringboot.entity.EmployeeStatusEntity;

@Component
public class EmployeeStatusConverter implements IGeneralConverter<EmployeeStatusDTO, EmployeeStatusEntity> {

	@Override
	public EmployeeStatusEntity toEntity(EmployeeStatusDTO d) {
		EmployeeStatusEntity e = new EmployeeStatusEntity();
		e.setCode(d.getCode());
		e.setName(d.getName());
		return e;
	}

	@Override
	public EmployeeStatusDTO toDTO(EmployeeStatusEntity e) {
		EmployeeStatusDTO d = new EmployeeStatusDTO();
		d.setCode(e.getCode());
		d.setName(e.getName());
		d.setId(e.getId());
		return d;
	}

	@Override
	public List<EmployeeStatusEntity> toListEntity(List<EmployeeStatusDTO> ds) {
		List<EmployeeStatusEntity> es = new ArrayList<>();
		for(EmployeeStatusDTO d : ds) {
			es.add(toEntity(d));
		}
		return es;
	}

	@Override
	public List<EmployeeStatusDTO> toListDTO(List<EmployeeStatusEntity> es) {
		List<EmployeeStatusDTO> ds = new ArrayList<>();
		for(EmployeeStatusEntity e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public EmployeeStatusEntity toOldEntity(EmployeeStatusDTO d, EmployeeStatusEntity oldE) {
		oldE.setCode(d.getCode());
		oldE.setName(d.getName());
		return oldE;
	}

	@Override
	public Page<EmployeeStatusDTO> toPagesDTO(Page<EmployeeStatusEntity> pageE) {
		return pageE.map(t -> toDTO(t));
	}

}
