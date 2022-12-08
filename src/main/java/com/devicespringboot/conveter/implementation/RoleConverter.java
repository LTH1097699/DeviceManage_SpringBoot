package com.devicespringboot.conveter.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.devicespringboot.conveter.IGeneralConverter;
import com.devicespringboot.dto.RoleDTO;
import com.devicespringboot.entity.RoleEntity;

@Component
public class RoleConverter implements IGeneralConverter<RoleDTO, RoleEntity> {

	@Override
	public RoleEntity toEntity(RoleDTO d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO toDTO(RoleEntity e) {
		RoleDTO d = new RoleDTO();
		d.setRoleCode(e.getRoleCode());
		d.setRoleName(e.getRoleName());
		return d;
	}

	@Override
	public List<RoleEntity> toListEntity(List<RoleDTO> ds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDTO> toListDTO(List<RoleEntity> es) {
		List<RoleDTO> ds = new ArrayList<>();
		for(RoleEntity e : es) {
			ds.add(toDTO(e));
		}
		return ds;
	}

	@Override
	public RoleEntity toOldEntity(RoleDTO d, RoleEntity oldE) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RoleDTO> toPagesDTO(Page<RoleEntity> pageE) {
		// TODO Auto-generated method stub
		return null;
	}

}
