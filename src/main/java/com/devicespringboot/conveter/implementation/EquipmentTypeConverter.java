package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EquipmentTypeDTO;
import com.devicespringboot.entity.EquipmentTypeEntity;

@Component
public class EquipmentTypeConverter implements IGeneralConverter<EquipmentTypeDTO, EquipmentTypeEntity> {

	@Override
	public EquipmentTypeEntity toEntity(EquipmentTypeDTO d) {
		EquipmentTypeEntity e = new EquipmentTypeEntity();
		e.setCode(d.getCode());
		e.setName(d.getName());
		return e;
	}

	@Override
	public EquipmentTypeDTO toDTO(EquipmentTypeEntity e) {
		EquipmentTypeDTO d = new EquipmentTypeDTO();
		d.setCode(e.getCode());
		d.setName(e.getName());
		d.setId(e.getId());
		return d;
	}

	@Override
	public List<EquipmentTypeEntity> toListEntity(List<EquipmentTypeDTO> ds) {
		List<EquipmentTypeEntity> es = new ArrayList<>();
		for(EquipmentTypeDTO d : ds) {
			es.add(toEntity(d));
		}
		return es;
	}

	@Override
	public List<EquipmentTypeDTO> toListDTO(List<EquipmentTypeEntity> es) {
		List<EquipmentTypeDTO> ds = new ArrayList<>();
		for(EquipmentTypeEntity e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public EquipmentTypeEntity toOldEntity(EquipmentTypeDTO d, EquipmentTypeEntity oldE) {
		oldE.setCode(d.getCode());
		oldE.setName(d.getName());
		return oldE;
	}

	@Override
	public Page<EquipmentTypeDTO> toPagesDTO(Page<EquipmentTypeEntity> pageE) {
		return pageE.map(t -> toDTO(t));
	}
	
	
	public Slice<EquipmentTypeDTO> toSliceDTO(Slice<EquipmentTypeEntity> sliceE) {
		return sliceE.map(t -> toDTO(t));
	}

}
