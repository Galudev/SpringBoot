package com.SpringBoot09.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = {"/hello","/hola","/salut"})
	public String saludar() {
		return "Hello, hola, salut";
	}
	
}

