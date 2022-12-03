package com.devicespringboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devicespringboot.dto.EquipmentStatusDTO;
import com.devicespringboot.service.implementation.EquipmentStatusService;



@Controller
@RequestMapping(value = "equipmentstatus")
public class EquipmentStatusController {

	@Autowired
	private EquipmentStatusService equipmentStatusService;

	@RequestMapping(value = { "/edit", "/edit/{id}" }, method = RequestMethod.GET)
	public String getAddView(@PathVariable Map<String, String> pathVariableMap, Model model) {
		if (pathVariableMap.containsKey("id")) {
			EquipmentStatusDTO d = equipmentStatusService.findOneById(Long.parseLong(pathVariableMap.get("id")));
			model.addAttribute("equipmentStatus", d);
		}
		model.addAttribute("equipmentStatus", new EquipmentStatusDTO());
		return "equipment/equipment_status/add";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getListView(@RequestParam(name = "page", required = false) Integer page, Model model) {
		List<EquipmentStatusDTO> dtos;
		if (page != null) {
			Pageable pageable = PageRequest.of(page - 1, 10);
			dtos = equipmentStatusService.findAll(pageable);
		} else {
			Pageable pageable = PageRequest.of(0, 10);
			dtos = equipmentStatusService.findAll(pageable);
		}

		model.addAttribute("equipmentStatus", dtos);
		return "equipment/equipment_status/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Long add(@RequestBody EquipmentStatusDTO equipmentStatus) {
		return equipmentStatusService.save(equipmentStatus).getId();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		if(!equipmentStatusService.existsById(Long.valueOf(id))) {
			equipmentStatusService.delete(Long.parseLong(id));
		}
	}
}
