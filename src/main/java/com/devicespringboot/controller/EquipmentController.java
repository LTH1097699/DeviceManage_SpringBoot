package com.devicespringboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devicespringboot.constant.Constant;
import com.devicespringboot.conveter.FileUpload;
import com.devicespringboot.dto.EquipmentDTO;
import com.devicespringboot.service.IEquipmentService;

@Controller
@RequestMapping(value = "equipment")
public class EquipmentController extends AbstractController<EquipmentDTO> {

	@Autowired
	private IEquipmentService equipmentService;
	
	@Autowired
	private FileUpload upload;

	@GetMapping(value = "/edit")
	public String getAddView(@RequestParam(name = "message", required = false) String message,
			Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		model.addAttribute("equipment", new EquipmentDTO());
		return "equipment/add";
	}

	@GetMapping(value = "/edit/{id}")
	public String getEditView(@RequestParam(name = "message", required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		
		model.addAttribute("equipment", equipmentService.findOneById(Long.parseLong(pathVariableMap.get("id"))));
		return "equipment/add";
	}

	@GetMapping
	public String getListView(@RequestParam(name = "message", required = false) String message,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		
		Sort pageSort = Sort.by(Direction.DESC, sort);

		Pageable pageable = PageRequest.of(page - 1, 10, pageSort);
		Page<EquipmentDTO> pageDTO = equipmentService.findAllPage(pageable);

		model.addAttribute("pageDTO", pageDTO);
		return "equipment/list";
	}
	
	
	@GetMapping(value = "/pagination")
	public String getListViewPagination(
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort, Model model) {

		Sort pageSort = Sort.by(Direction.DESC, sort);

		Pageable pageable = PageRequest.of(page - 1, 10, pageSort);
		Page<EquipmentDTO> pageDTO = equipmentService.findAllPage(pageable);

		model.addAttribute("pageDTO", pageDTO);
		return "equipment/table";
	}

	
	@PostMapping(value = "/edit", produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> add(@ModelAttribute EquipmentDTO equipment) {
		
		String fileName = upload.uploadImage(equipment.getMultipartFile());
		equipment.setMultipartFile(null);
		equipment.setFile(fileName);
		
		equipmentService.save(equipment).getId();
		return new ResponseEntity<>("Susccesfull", HttpStatus.OK);
	}

}
