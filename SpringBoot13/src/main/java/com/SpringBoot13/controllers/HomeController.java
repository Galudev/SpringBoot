package com.SpringBoot13.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/{XXXXX}/factura")
	@ResponseBody
	public String esParOImpar(@PathVariable(name = "XXXXX") int num) {
		return num%2==0 ? "Es par" : "Es impar";
	}
}
