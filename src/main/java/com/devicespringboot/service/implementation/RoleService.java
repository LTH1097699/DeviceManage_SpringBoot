package com.devicespringboot.service.implementation;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devicespringboot.dto.RoleDTO;
import com.devicespringboot.repository.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<RoleDTO> findAll(){
		
		List<RoleDTO> dtos = new ArrayList<>();
//		List<RoleEntity> entites = roleRepository.findAll();
//		for(RoleEntity entity : entites) {
//			dtos.add(mapper.map(entity, RoleDTO.class));
//		}
		return dtos;
	}
	
	
}
