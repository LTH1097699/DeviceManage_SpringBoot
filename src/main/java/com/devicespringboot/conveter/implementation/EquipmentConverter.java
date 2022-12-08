package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.entity.EquipmentEntity;
import com.devicespringboot.repository.EquipmentStatusRepository;
import com.devicespringboot.repository.EquipmentTypeRepository;


@Component
public class EquipmentConverter implements IGeneralConverter<EquipmentDTO, EquipmentEntity>{
	@Autowired
	private EquipmentStatusRepository statusRepository;
	
	@Autowired
	private EquipmentTypeRepository typeRepository;
	
	@Autowired
	private EquipmentStatusConverter statusConverter;
	
	@Autowired
	private EquipmentTypeConverter typeConverter;

	@Override
	public EquipmentEntity toEntity(EquipmentDTO d) {
		EquipmentEntity e = new EquipmentEntity();
		e.setName(d.getName());
		e.setDescription(d.getDescription());
		e.setFileName(d.getFile());
		e.setEquipId(d.getEquipId());
		
		e.setEquipmentType(typeRepository.findOneByCode(d.getType().getCode()));
		e.setStatus(statusRepository.findOneByCode(d.getStatus().getCode()));
		return e;
	}

	@Override
	public EquipmentDTO toDTO(EquipmentEntity e) {
		EquipmentDTO d = new EquipmentDTO();
		d.setName(e.getName());
		d.setDescription(e.getDescription());
		d.setId(e.getId());
		d.setFile(e.getFileName());
		d.setEquipId(e.getEquipId());
		d.setStatus(statusConverter.toDTO(e.getStatus()));
		d.setType(typeConverter.toDTO(e.getEquipmentType()));
		return d;
	}

	@Override
	public List<EquipmentEntity> toListEntity(List<EquipmentDTO> ds) {
		List<EquipmentEntity> es = new ArrayList<>();
		for(EquipmentDTO d : ds) {
			es.add(toEntity(d));
		}
		return es;
	}

	@Override
	public List<EquipmentDTO> toListDTO(List<EquipmentEntity> es) {
		List<EquipmentDTO> ds = new ArrayList<>();
		for(EquipmentEntity e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public EquipmentEntity toOldEntity(EquipmentDTO d, EquipmentEntity oldE) {
		oldE.setName(d.getName());
		oldE.setDescription(d.getDescription());
		
		oldE.setFileName(d.getFile());
		oldE.setEquipId(d.getEquipId());
		
		oldE.setEquipmentType(typeRepository.findOneByCode(d.getType().getCode()));
		oldE.setStatus(statusRepository.findOneByCode(d.getStatus().getCode()));
		return oldE;
	}

	@Override
	public Page<EquipmentDTO> toPagesDTO(Page<EquipmentEntity> pageE) {
		
		return pageE.map(t -> toDTO(t));
	}

}
