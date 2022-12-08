package com.devicespringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoController {
	
	
	@GetMapping(value = "/user-list")
	//use requestPart nhan file upload tu client
	public String getListView(@RequestPart("file") MultipartFile file) {
		
		
		//return "forward:/employee/list"; co the chuyen doi data do duoc thuc thi tai server
		//return "redirect:/employee/list"; tao mot request moi nen se mat du lieu, de chuyen data can su dung RedirectAttributes
		return "employee/list";
	}
	
	
	@GetMapping(value = "/user")
	public void getListView1(@RequestPart("file") MultipartFile file) {
		//neu la void se return a view voi path=/user-list
	}
	
	@ResponseBody
	@GetMapping(value = "/userlist")
	public void getListView2(@RequestPart("file") MultipartFile file) {
		//neu la void se return empty
	}
	
	
	//controller organization
	/*
	 * /crud/index 
	 * /crud/get 
	 * /crud/delete/{id} 
	 * /crud/edit/{id} 
	 * /crud/update
	 */
	
}
