package com.devicespringboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devicespringboot.constant.Constant;
import com.devicespringboot.dto.EquipmentTypeDTO;
import com.devicespringboot.service.implementation.EquipmentTypeService;



@Controller
@ControllerAdvice
@RequestMapping(value = "equipmenttype")
public class EquipmentTypeController extends AbstractController<EquipmentTypeDTO> {
	@Autowired
	private EquipmentTypeService equipmentTypeService;
	
	

	@GetMapping(value = "/edit")
	public String getAddView(@RequestParam(name = "message", required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}

		model.addAttribute("equipmentType", new EquipmentTypeDTO());

		return "equipment_type/add";
	}

	@GetMapping(value = "/edit/{id}")
	public String getEditView(@RequestParam(name = "message", required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}

		model.addAttribute("equipmentType",
				equipmentTypeService.findOneById(Long.parseLong(pathVariableMap.get("id"))));

		return "equipment_type/add";
	}

	@GetMapping
	public String getListView(@RequestParam(name = "message", required = false) String message,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort,
			Model model) {
		
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		Sort sort2 = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10,sort2);
		
		Page<EquipmentTypeDTO> pageDTO = equipmentTypeService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);
		
		
		
		return "equipment_type/list";
	}
	
	
	@GetMapping(value = "/pagination")
	public String getListViewPage(
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort,
			Model model) {
		
		Sort sort2 = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10,sort2);
		
		Page<EquipmentTypeDTO> pageDTO = equipmentTypeService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);

		return "equipment_type/table";
	}

	@ResponseBody
	@PostMapping(value = "/edit")
	public Long add(@RequestBody EquipmentTypeDTO equipmentType) {
		return equipmentTypeService.save(equipmentType).getId();
	}
	
	@ModelAttribute(name = "equipmentTypeList")
	public List<EquipmentTypeDTO>  getEquipmentType(){
		return equipmentTypeService.findAll();
	}
}
