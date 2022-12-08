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

import com.devicespringboot.conveter.FileUpload;
import com.devicespringboot.dto.EmployeeDTO;
import com.devicespringboot.service.IEmployeeService;
import com.devicespringboot.service.implementation.RoleService;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController extends AbstractController<EmployeeDTO> {
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private FileUpload upload;

	@Autowired
	private RoleService roleService;

	@GetMapping(value = { "/edit" })
	public String getAddView(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		model.addAttribute("roles", roleService.findAll());

		return "employee/add";
	}

	@GetMapping(value = { "/edit/{id}" })
	public String getEditView(@PathVariable Map<String, String> pathVariableMap, Model model) {
		model.addAttribute("employee", employeeService.findOneById(Long.parseLong(pathVariableMap.get("id"))));
		model.addAttribute("roles", roleService.findAll());

		return "employee/add";
	}

	@GetMapping
	public String getListView(@RequestParam(name = "message", required = false) String message,
			@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort, Model model) {
		Sort sort2 = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10, sort2);

		Page<EmployeeDTO> pageDTO = employeeService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);
		return "employee/list";
	}

	@GetMapping(value = "/pagination")
	public String getListViewPagination(@RequestParam(defaultValue = "1", name = "page", required = false) Integer page,
			@RequestParam(defaultValue = "id", name = "sort", required = false) String sort, Model model) {
		Sort sort2 = Sort.by(Direction.DESC, sort);
		Pageable pageable = PageRequest.of(page - 1, 10, sort2);

		Page<EmployeeDTO> pageDTO = employeeService.findAllPage(pageable);
		model.addAttribute("pageDTO", pageDTO);

		return "employee/table";
	}

	@PostMapping(value = "/edit")
	public ResponseEntity<String> add(@ModelAttribute EmployeeDTO employee) {
		String fileName = upload.uploadImage(employee.getMultipartFile());
		employee.setMultipartFile(null);
		employee.setAvatar(fileName);
		
		employeeService.save(employee).getId();
		return new ResponseEntity<>("Successfull", HttpStatus.OK);
	}

}
