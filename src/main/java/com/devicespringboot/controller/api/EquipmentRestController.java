package com.devicespringboot.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.service.IEquipmentService;



@RestController
public class EquipmentRestController {
	@Autowired
	private IEquipmentService equipmentService;
	
	@RequestMapping(value = "/api/equipment", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody EquipmentDTO dto) {
//		return equipmentService.save(equipment); 
		return null;
	}
	
	@RequestMapping(value = "/api/equipment/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(name = "id") String id) {
		equipmentService.delete(Long.parseLong(id));
	}
}
