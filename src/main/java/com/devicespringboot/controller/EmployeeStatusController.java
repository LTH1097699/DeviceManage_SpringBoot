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

import com.devicespringboot.dto.EmployeeStatusDTO;
import com.devicespringboot.service.implementation.EmployeeStatusService;


@Controller
public class EmployeeStatusController {
	
	@Autowired
	private EmployeeStatusService employeeStatusService;
	
	@RequestMapping(value = {"/employee-status/edit","/employee-status/edit/{id}"}, method = RequestMethod.GET)
	public String getAddView(@PathVariable Map<String, String> pathVariableMap, Model model) {
		if(pathVariableMap.containsKey("id")) {
			
		}
		return "/employee/employee_status/add";
	}
	
	@RequestMapping(value = "/employee-status/list", method = RequestMethod.GET)
	public String getListView(@RequestParam(name = "page",required = false) Integer page, Model model) {
		List<EmployeeStatusDTO> dtos = new ArrayList<>();
		if(page != null) {
			Pageable pageable = PageRequest.of(page-1, 10);
			dtos = employeeStatusService.findAll(pageable);
		}else {
			Pageable pageable = PageRequest.of(0, 10);
			dtos = employeeStatusService.findAll(pageable);
		}
		model.addAttribute("",dtos);
		return "/employee/employee_status/list";
	}
}
