package com.devicespringboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.service.IEquipmentService;

@Controller
@RequestMapping(value = "equipment")
public class EquipmentController {

	@Autowired
	private IEquipmentService equipmentService;

	@GetMapping(value = "/edit")
	public String getAddView(@PathVariable Map<String, String> pathVariableMap, Model model) {

		model.addAttribute("equipment", new EquipmentDTO());

		return "equipment/add";
	}

	@GetMapping(value = "/edit/{id}")
	public String getEditView(@PathVariable Map<String, String> pathVariableMap, Model model) {

		model.addAttribute("equipment", equipmentService.findOneById(Long.parseLong(pathVariableMap.get("id"))));

		return "equipment/add";
	}

	@GetMapping
	public String getListView(@RequestParam("page") Integer page, Model model) {

		List<EquipmentDTO> dtos;
		if (page != null) {
			Pageable pageable = PageRequest.of(page - 1, 10);
			dtos = equipmentService.findAll(pageable);
		} else {
			Pageable pageable = PageRequest.of(0, 10);
			dtos = equipmentService.findAll(pageable);
		}
		model.addAttribute("equipmentTypes", dtos);
		return "equipment/list";
	}

	@PostMapping(value = "/eqip/edit")
	public Long add(@RequestBody EquipmentDTO equipment) {
		return equipmentService.save(equipment).getId();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		if (!equipmentService.existsById(Long.valueOf(id))) {
			equipmentService.delete(Long.parseLong(id));
		}
	}
}
