package com.SpringBoot12.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/test")
	@ResponseBody
	public String inf(@RequestParam int edad) {
		return edad>=18 ? "Puedes pasar!" : "No puedes pasar tronc@!";
	}
}