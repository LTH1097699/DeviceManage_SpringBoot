package com.devicespringboot.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.devicespringboot.dto.EquipmentTypeDTO;

public class EquipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EquipmentTypeDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
	}

	

}
