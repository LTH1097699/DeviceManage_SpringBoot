package com.devicespringboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.devicespringboot.dto.EquipmentDTO;



public interface IEquipmentService extends IGeneralService<EquipmentDTO> {
	List<EquipmentDTO> findAll(Pageable pageable);
}
