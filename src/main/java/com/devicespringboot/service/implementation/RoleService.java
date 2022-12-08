package com.devicespringboot.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devicespringboot.conveter.implementation.RoleConverter;
import com.devicespringboot.dto.RoleDTO;
import com.devicespringboot.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;
	
	public List<RoleDTO> findAll(){
		return roleConverter.toListDTO(roleRepository.findAll());
	}
	
	
}
