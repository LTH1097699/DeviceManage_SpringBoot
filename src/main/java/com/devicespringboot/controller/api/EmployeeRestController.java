package com.devicespringboot.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.service.IEmployeeService;


@RestController
public class EmployeeRestController {
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value = "/api/employee", method = RequestMethod.POST)
	public Long add(@RequestBody EmployeeDTO employee) {
		return ((EmployeeRestController) employeeService).add(employee);
	}
	
	@DeleteMapping(value = "/api/delete/employee/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		employeeService.delete(Long.parseLong(id));
		
	}
}
