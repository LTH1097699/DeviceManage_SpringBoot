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
import org.springframework.web.bind.annotation.RequestParam;

import com.devicespringboot.dto.EmployeeStatusDTO;
import com.devicespringboot.service.implementation.EmployeeStatusService;


@Controller
@RequestMapping(value = "employeestatus")
public class EmployeeStatusController {
	
	@Autowired
	private EmployeeStatusService employeeStatusService;
	
	@GetMapping(value = "/list")
	public String getListView(@RequestParam(name = "page",required = false) Integer page, Model model) {
		List<EmployeeStatusDTO> dtos;
		if(page != null) {
			Pageable pageable = PageRequest.of(page-1, 10);
			dtos = employeeStatusService.findAll(pageable);
		}else {
			Pageable pageable = PageRequest.of(0, 10);
			dtos = employeeStatusService.findAll(pageable);
		}
		model.addAttribute("",dtos);
		return "employee/employee_status/list";
	}
	
	@PostMapping(value = "/edit")
	public Long add(@RequestBody EmployeeStatusDTO employeeStatus) {
		return employeeStatusService.save(employeeStatus).getId();
	}
	
	@DeleteMapping(value = "/deletee/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		if(!employeeStatusService.existsById(Long.valueOf(id))) {
			employeeStatusService.delete(Long.parseLong(id));
		}
	}
	
}
