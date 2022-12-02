package com.devicespringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.service.IEquipmentService;



@Controller
public class EquipmentController {
	
	@Autowired
	private IEquipmentService equipmentService;
	
	@RequestMapping(value = {"/equipment/edit","/equipment/edit/{id}"}, method = RequestMethod.GET)
	public String getAddView(@PathVariable Map<String, String> pathVariableMap, Model model) {
		if(pathVariableMap.containsKey("id")) {
			model.addAttribute("equipment", equipmentService.findOneById(Long.parseLong(pathVariableMap.get("id"))));
		}else {
			model.addAttribute("equipment", new EquipmentDTO());	
		}
		return "/equipment/add";
	}
	
	@RequestMapping(value = "/equipment/list", method = RequestMethod.GET)
	public String getListView(@RequestParam("page") Integer page, Model model) {
		
		List<EquipmentDTO> dtos = new ArrayList<>();
		if(page != null) {
			Pageable pageable = PageRequest.of(page-1, 10);
			dtos = equipmentService.findAll(pageable);
		}else {
			Pageable pageable = PageRequest.of(0, 10);
			dtos = equipmentService.findAll(pageable);
		}
		model.addAttribute("equipmentTypes",dtos);
		return "/equipment/list";
	}
}
