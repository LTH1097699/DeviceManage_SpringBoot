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

import com.devicespringboot.dto.EquipmentTypeDTO;
import com.devicespringboot.service.implementation.EquipmentTypeService;


@Controller
@RequestMapping(value = "equipmenttype")
public class EquipmentTypeController {
	@Autowired
	private EquipmentTypeService equipmentTypeService;
	
	
	@GetMapping(value = "/equipment-type/edit")
	public String getAddView(@RequestParam(name="message",required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if(message!=null && !message.isEmpty()) {
			model.addAttribute("message",message);
		}
		
		
	
			model.addAttribute("equipmentType", new EquipmentTypeDTO());	
		
		return "equipment_type/add";
	}
	
	@GetMapping(value = "/equipment-type/edit/{id}")
	public String getEditView(@RequestParam(name="message",required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if(message!=null && !message.isEmpty()) {
			model.addAttribute("message",message);
		}
		
		
		
			model.addAttribute("equipmentType", equipmentTypeService.findOneById(Long.parseLong(pathVariableMap.get("id"))));
		
		return "equipment_type/add";
	}
	
	@GetMapping
	public String getListView(@RequestParam(name="message",required = false) String message,
			@RequestParam(name = "page",required = false) Integer page, Model model) {
		if(message!=null && !message.isEmpty()) {
			model.addAttribute("message",message);
		}
		int totalPages=0;
		totalPages =(int) Math.ceil((double) equipmentTypeService.findAll().size()/10);
		
		List<EquipmentTypeDTO> dtos;
		if(page != null) {
			Pageable pageable = PageRequest.of(page-1, 10);
			dtos = equipmentTypeService.findAll(pageable);
			
			model.addAttribute("page",page);
		}else {
			Pageable pageable = PageRequest.of(0, 10);
			dtos = equipmentTypeService.findAll(pageable);
			model.addAttribute("page",1);
		}
		model.addAttribute("equipmentTypes",dtos);
		
		
        model.addAttribute("totalPages",totalPages);
		
		return "equipment_type/list";
	}
	
	@PostMapping(value = "/edit")
	public Long add(@RequestBody EquipmentTypeDTO equipmentType) {
		return equipmentTypeService.save(equipmentType).getId();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		if(!equipmentTypeService.existsById(Long.valueOf(id))) {
			equipmentTypeService.delete(Long.parseLong(id));
		}
	}
}
