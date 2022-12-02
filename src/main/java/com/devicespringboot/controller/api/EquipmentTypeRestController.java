package com.devicespringboot.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devicespringboot.dto.EquipmentTypeDTO;
import com.devicespringboot.service.implementation.EquipmentTypeService;



@RestController
public class EquipmentTypeRestController {
	@Autowired
	private EquipmentTypeService equipmentTypeService;
	
	@RequestMapping(value = "/api/equipment-type", method = RequestMethod.POST)
	public EquipmentTypeDTO add(@RequestBody EquipmentTypeDTO equipmentType) {
		return equipmentTypeService.save(equipmentType);
	}
	
	@RequestMapping(value = "/api/equipment-type/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id") String id) {
		equipmentTypeService.delete(Long.parseLong(id));
	}
}
