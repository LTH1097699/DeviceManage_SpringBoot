package com.devicespringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/")
public class HomeController {
	
	@GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        return "sign_in";
    }
	
	@GetMapping(value = "/register")
    public String register(Model model, String error, String logout) {
        return "sign_up";
    }
}
