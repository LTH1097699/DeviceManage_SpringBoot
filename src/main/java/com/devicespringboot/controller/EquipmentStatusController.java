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
import com.devicespringboot.dto.EquipmentStatusDTO;
import com.devicespringboot.service.implementation.EquipmentStatusService;

@Controller
@ControllerAdvice
@RequestMapping(value = "equipmentstatus")
public class EquipmentStatusController extends AbstractController<EquipmentStatusDTO> {

	@Autowired
	private EquipmentStatusService equipmentStatusService;

	@GetMapping(value = "/edit")
	public String getAddView(@RequestParam(name = "message", required = false) String message,
			Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		
		model.addAttribute("equipmentStatus", new EquipmentStatusDTO());
		return "equipment_status/add";
	}

	@GetMapping(value = "/edit/{id}")
	public String getEditView(@RequestParam(name = "message", required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		EquipmentStatusDTO d = equipmentStatusService.findOneById(Long.parseLong(pathVariableMap.get("id")));
		model.addAttribute("equipmentStatus", d);

		return "equipment_status/add";
	}

	@GetMapping
	public String getListView(@RequestParam(name = "message", required = false) String message,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		
		Sort sortPage = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10, sortPage);
		Page<EquipmentStatusDTO> pageDTO = equipmentStatusService.findAllPage(pageable);

		model.addAttribute("pageDTO", pageDTO);
		return "equipment_status/list";
	}
	
	@GetMapping(value = "/pagination")
	public String getListViewPage(
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort,
			Model model) {
		
		Sort sortPage = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10, sortPage);
		
		Page<EquipmentStatusDTO> pageDTO = equipmentStatusService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);

		return "equipment_type/table";
	}

	@ResponseBody
	@PostMapping(value = "/edit")
	public Long add(@RequestBody EquipmentStatusDTO equipmentStatus) {
		return equipmentStatusService.save(equipmentStatus).getId();
	}
	
	@ModelAttribute(name = "equipmentStatusList")
	public List<EquipmentStatusDTO> getEquipmentStatusList(){
		return equipmentStatusService.findAll();
	}
}
