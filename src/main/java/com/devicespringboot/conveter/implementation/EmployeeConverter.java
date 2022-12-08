package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.entity.EmployeeEntity;
import com.devicespringboot.repository.EmployeeStatusRepository;

@Component
public class EmployeeConverter implements IGeneralConverter<EmployeeDTO, EmployeeEntity> {
	
	@Autowired
	private AccountConverter accountConverter;
	
	@Autowired
	private EmployeeStatusRepository statusRepository;
	
	@Autowired
	private EmployeeStatusConverter statusConverter;

	@Override
	public EmployeeEntity toEntity(EmployeeDTO d) {
		EmployeeEntity e = new EmployeeEntity();
		e.setAccount(accountConverter.toEntity(d.getAccount()));
		e.setName(d.getName());
		e.setStatus(statusRepository.findByCode(d.getStatus().getCode()));
		e.setAvatar(d.getAvatar());
		return e;
	}

	@Override
	public EmployeeDTO toDTO(EmployeeEntity e) {
		EmployeeDTO d = new EmployeeDTO();
		d.setAccount(accountConverter.toDTO(e.getAccount()));
		d.setStatus(statusConverter.toDTO(e.getStatus()));
		d.setName(e.getName());
		d.setId(e.getId());
		d.setAvatar(e.getAvatar());
		return d;
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

	@Override
	public Page<EmployeeDTO> toPagesDTO(Page<EmployeeEntity> pageE) {
		return pageE.map(t -> toDTO(t));
	}

}
