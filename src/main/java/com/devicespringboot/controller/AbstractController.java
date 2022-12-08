package com.devicespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devicespringboot.service.IGeneralService;

public abstract class AbstractController<D> {
	@Autowired
	IGeneralService<D> service;
	
	@ResponseBody
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") String id) {
		if (service.existsById(Long.valueOf(id))) {
			service.delete(Long.parseLong(id));
		}
		return new ResponseEntity<>("Succesfull", HttpStatus.OK);
	}

}
