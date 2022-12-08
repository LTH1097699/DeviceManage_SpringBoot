package com.devicespringboot.dto;


import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EmployeeDTO extends AbstractDTO<EmployeeDTO> {
	
	private String name;
	
	private String avatar;
	
	private MultipartFile multipartFile;
	
	private EmployeeStatusDTO status;
	
	private AccountDTO account;

}
