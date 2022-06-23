package com.SpringBoot10.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class HomeController {

	@RequestMapping("welcome1")
	public String bienvenida(@RequestParam(required=false) String name, String surname) {
		return "Bienvenid@ " + name + " " + surname + "!";
	}
	
	@RequestMapping("welcome2")
	public ObjectNode bienvenida2(@RequestParam(required=false) String name, String surname) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("name", name);
		objectNode.put("surname", surname);
		return objectNode;
	}
	
	@RequestMapping("welcome3")
	public ObjectNode bienvenida3(@RequestParam(required=false, defaultValue = "desconocido") String name, @RequestParam(required=false, defaultValue = "desconocidos") String surname) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("name", name);
		objectNode.put("surname", surname);
		return objectNode;
	}
}