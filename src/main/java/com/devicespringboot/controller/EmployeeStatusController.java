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

import com.devicespringboot.constant.Constant;
import com.devicespringboot.dto.EmployeeStatusDTO;
import com.devicespringboot.service.implementation.EmployeeStatusService;


@Controller
@ControllerAdvice
@RequestMapping(value = "employeestatus")
public class EmployeeStatusController extends AbstractController<EmployeeStatusDTO> {
	
	@Autowired
	private EmployeeStatusService employeeStatusService;
	
	@GetMapping(value = "/edit")
	public String getAddView(@RequestParam(name = "message", required = false) String message,
			Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		
		model.addAttribute("employeeStatus", new EmployeeStatusDTO());
		return "employee_status/add";
	}

	@GetMapping(value = "/edit/{id}")
	public String getEditView(@RequestParam(name = "message", required = false) String message,
			@PathVariable Map<String, String> pathVariableMap, Model model) {
		if (message != null && !message.isEmpty()) {
			model.addAttribute(Constant.MESSAGE, message);
		}
		EmployeeStatusDTO d = employeeStatusService.findOneById(Long.parseLong(pathVariableMap.get("id")));
		model.addAttribute("employeeStatus", d);

		return "employee_status/add";
	}
	
	@GetMapping
	public String getListView(@RequestParam(name = "message", required = false) String message,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort,
			Model model) {
		Sort sort2 = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10,sort2);
		
		Page<EmployeeStatusDTO> pageDTO = employeeStatusService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);
		return "employee_status/list";
	}
	
	@GetMapping(value = "/pagination")
	public String getListViewPagination(
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort, 
			Model model) {
		Sort sort2 = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10,sort2);
		
		Page<EmployeeStatusDTO> pageDTO = employeeStatusService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);

		return "employee_status/table";
	}
	
	@PostMapping(value = "/edit")
	public Long add(@RequestBody EmployeeStatusDTO employeeStatus) {
		return employeeStatusService.save(employeeStatus).getId();
	}
	
	@ModelAttribute(name = "employeeStatus")
	public List<EmployeeStatusDTO> getEmployeeStatusList(){
		return employeeStatusService.findAll();
	}
	
}
